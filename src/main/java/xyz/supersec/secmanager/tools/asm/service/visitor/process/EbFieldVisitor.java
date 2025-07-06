package xyz.supersec.secmanager.tools.asm.service.visitor.process;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.TypePath;

import xyz.supersec.secmanager.tools.asm.pojo.EbAnnInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbFieldInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAlertInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAnnTarget;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbStatus;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbUtils;

class EbFieldVisitor extends FieldVisitor {


    private EbFieldInfo ebFieldInfo;

    private EbAlertInfo ebAlertInfo;

    protected EbFieldVisitor(int api, EbFieldInfo ebFieldInfo, EbAlertInfo ebAlertInfo) {
        super(api);
        this.ebFieldInfo = ebFieldInfo;
        this.ebAlertInfo = ebAlertInfo;
    }

    protected EbFieldVisitor(int api, FieldVisitor fieldVisitor) {
        super(api, fieldVisitor);
    }

    @Override
    public FieldVisitor getDelegate() {
        return super.getDelegate();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        ebAlertInfo.setAlert("字段注解");
        EbAnnInfo ebAnnInfo = new EbAnnInfo();

        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTargetType(EbAnnTarget.field.toString())
                .setPId(ebAlertInfo.getProjectId())
                .setDataFlag(EbStatus.ok);

        ebFieldInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {

        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTypeRef(typeRef).setTypePath(typePath.toString())
                .setTargetType(EbAnnTarget.field.toString())
                .setPId(ebAlertInfo.getProjectId())
                .setDataFlag(EbStatus.ok);

        ebFieldInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        ebAlertInfo.setAlert("字段自定义属性");

        String str = attribute + "$$";
        ebFieldInfo.setAttribute(ebFieldInfo.getAttribute() + str);

        super.visitAttribute(attribute);
    }

    @Override
    public void visitEnd() {
        ebFieldInfo.setDataFlag(EbStatus.ok);
        super.visitEnd();
    }
}
