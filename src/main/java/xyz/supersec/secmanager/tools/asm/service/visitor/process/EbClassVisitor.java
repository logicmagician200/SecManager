package xyz.supersec.secmanager.tools.asm.service.visitor.process;


import java.util.Arrays;
import java.util.UUID;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.db.entity.BcInnerClassInfo;
import xyz.supersec.secmanager.db.entity.BcRecordComponentInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbClassInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbFieldInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbMethodInfo;
import xyz.supersec.secmanager.tools.asm.service.common.Acc_utils;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAlertInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAnnTarget;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbStatus;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbUtils;

@Slf4j
class EbClassVisitor extends ClassVisitor {

    // 存放一个 class 文件解析出的所有内容
    private EbClassInfo ebClassInfo;

    // 存放当前的解析信息，用作警告功能
    private EbAlertInfo ebAlertInfo;

    public EbClassVisitor(int api, EbClassInfo ebClassInfo) {
        super(api);
        this.ebClassInfo = ebClassInfo;
    }

    @Override
    public ClassVisitor getDelegate() {
        return super.getDelegate();
    }

    /**
     * 访问 class 的头数据
     * @param version   class 文件的版本信息
     * @param access    访问标识
     * @param name  类的名称
     * @param signature 类的签名信息
     * @param superName 当前类的父类
     * @param interfaces    当前类实现的接口
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {

        ebClassInfo.setVersion(version).setAccess(EbUtils.getACC(access))
                .setAccessFlag(Acc_utils.class_acc(access))
                .setClassName(name).setClassUuid(EbUtils.md5(name))
                .setSignature(signature).setSuperName(superName)
                .setInterfaces(Arrays.stream(interfaces).toList().toString())
                .setDataFlag(EbStatus.running);

        ebAlertInfo = new EbAlertInfo();
        ebAlertInfo.setProjectId(ebClassInfo.getPId()).setClassName(ebClassInfo.getClassName());

        super.visit(version, access, name, signature, superName, interfaces);
    }


    /**
     * @param source 源代码文件名称，对应 class 文件中的 SourceFile 属性。
     * @param debug  对应 SourceDebugExtension 属性
     */
    @Override
    public void visitSource(String source, String debug) {

        ebClassInfo.setSource(source).setDebug(debug);

        super.visitSource(source, debug);
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {

        ebAlertInfo.setAlert("项目存在模块信息");

        ebClassInfo.setModuleName(name).setModuleAccess(access)
                .setModuleVersion(version);

        return super.visitModule(name, access, version);
    }

    @Override
    public void visitNestHost(String nestHost) {

        ebClassInfo.setNestHost(nestHost);

        super.visitNestHost(nestHost);
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {

        ebClassInfo.setOuterClassOwner(owner).setOuterClassName(name)
                .setOuterClassDescriptor(descriptor);

        super.visitOuterClass(owner, name, descriptor);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {

        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTargetUuid(ebClassInfo.getClassUuid())
                .setTargetType(EbAnnTarget.clazz.toString())
                .setPId(ebClassInfo.getPId())
                .setDataFlag(EbStatus.ok);

        ebClassInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {

        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTypeRef(typeRef).setTypePath(typePath.toString())
                .setTargetUuid(ebClassInfo.getClassUuid())
                .setTargetType(EbAnnTarget.clazz.toString())
                .setPId(ebClassInfo.getPId())
                .setDataFlag(EbStatus.ok);

        ebClassInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;

    }

    @Override
    public void visitAttribute(Attribute attribute) {
        ebAlertInfo.setAlert("项目存在自定义属性");

        // 使用 %% 作为多个 Attribute 的分隔符
        String str = attribute.toString() + "&&";
        ebClassInfo.setAttribute(ebClassInfo.getAttribute() + str);

        super.visitAttribute(attribute);
    }

    @Override
    public void visitNestMember(String nestMember) {
        ebAlertInfo.setAlert("项目存在 nestMember ");

        // 使用 %% 作为多个 Attribute 的分隔符
        String str = nestMember + "&&";
        ebClassInfo.setNestMember(ebClassInfo.getNestMember() + str);

        super.visitNestMember(nestMember);
    }

    @Override
    public void visitPermittedSubclass(String permittedSubclass) {
        ebAlertInfo.setAlert("项目存在 visitPermittedSubclass 信息");
        ebClassInfo.setPermittedSubclass(permittedSubclass);
        super.visitPermittedSubclass(permittedSubclass);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {

        BcInnerClassInfo innerClassInfo = new BcInnerClassInfo();
        innerClassInfo.setClassUuid(ebClassInfo.getClassUuid()).setInnerClassName(name)
                .setInnerClassOuterName(outerName).setInnerClassInnerName(innerName)
                .setInnerClassAccess(access)
                .setDataFlag(EbStatus.ok);

        ebClassInfo.getInnerClassInfos().add(innerClassInfo);

        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {

        BcRecordComponentInfo componentInfo = new BcRecordComponentInfo();
        componentInfo.setIndex(ebClassInfo.getClassUuid()).setRecordComponentName(name)
                .setRecordComponentDescriptor(descriptor).setRecordComponentSignature(signature)
                .setDataFlag(EbStatus.ok);

        ebClassInfo.getRecordComponentInfos().add(componentInfo);

        return super.visitRecordComponent(name, descriptor, signature);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {

        EbFieldInfo ebFieldInfo = new EbFieldInfo();
        ebFieldInfo.setPId(ebClassInfo.getPId()).setClassUuid(ebClassInfo.getClassUuid())
                .setAccess(EbUtils.getACC(access))
                .setAccessFlag(Acc_utils.field_acc(access))
                .setName(name).setDescriptor(descriptor)
                .setDataFlag(EbStatus.running);

        if (null != value) {
            ebFieldInfo.setValue(value.toString());
        }
        ebClassInfo.getEbFieldInfos().add(ebFieldInfo);

        ebAlertInfo.onlySetFieldName(name);

        EbFieldVisitor ebFieldVisitor = new EbFieldVisitor(EbUtils.ASM_version, ebFieldInfo, ebAlertInfo);
        return ebFieldVisitor;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        log.info("当前类的方法： {}，描述符为 {}", name, descriptor);
        EbMethodInfo ebMethodInfo = new EbMethodInfo();
        ebMethodInfo.setPId(ebClassInfo.getPId()).setClassUuid(ebClassInfo.getClassUuid())
                .setAccess(access).setAccessFlag(Acc_utils.method_acc(access))
                .setName(name).setDescriptor(descriptor).setSignature(signature)
                .setUuid(UUID.randomUUID().toString().replaceAll("-", ""))
                .setDataFlag(EbStatus.running);

        if (null != exceptions) {
            ebMethodInfo.setExceptions(Arrays.stream(exceptions).toList().toString());
        }

        ebClassInfo.getEbMethodInfos().add(ebMethodInfo);

        ebAlertInfo.onlySetMethodName(name);

        EbMethodVisitor methodVisitor = new EbMethodVisitor(EbUtils.ASM_version, ebMethodInfo, ebAlertInfo);
        return methodVisitor;
    }

    @Override
    public void visitEnd() {
        // 设置 方法数 和 属性数
        int method_num=ebClassInfo.getEbMethodInfos().size();
        int field_num= ebClassInfo.getEbFieldInfos().size();
        ebClassInfo.setMethodNum(method_num).setFieldNum(field_num);

        ebClassInfo.setAlertInfos(ebAlertInfo.getAlertInfos());
        ebClassInfo.setDataFlag(EbStatus.ok);

        super.visitEnd();
    }

}
