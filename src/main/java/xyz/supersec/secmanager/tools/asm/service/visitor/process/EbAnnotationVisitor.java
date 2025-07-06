package xyz.supersec.secmanager.tools.asm.service.visitor.process;

import java.util.List;

import org.objectweb.asm.AnnotationVisitor;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnContentInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAlertInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbUtils;

@Slf4j
class EbAnnotationVisitor extends AnnotationVisitor {
    private List<EbAnnContentInfo> ebAnnContentInfos;
    private EbAnnContentInfo ebAnnContentInfo;
    private EbAlertInfo ebAlertInfo;

    protected EbAnnotationVisitor(int api, List<EbAnnContentInfo> ebAnnContentInfos, EbAlertInfo ebAlertInfo) {
        super(api);
        this.ebAnnContentInfos = ebAnnContentInfos;
        this.ebAlertInfo = ebAlertInfo;
    }

    private EbAnnotationVisitor(int api, EbAnnContentInfo ebAnnContentInfo, EbAlertInfo ebAlertInfo) {
        super(api);
        this.ebAnnContentInfo = ebAnnContentInfo;
        this.ebAlertInfo = ebAlertInfo;
    }


    @Override
    public AnnotationVisitor getDelegate() {
        return super.getDelegate();
    }

    /**
     * 方法注解的 key value 键值对
     *
     * @param name  the value name.
     * @param value the actual value, whose type must be {@link Byte}, {@link Boolean}, {@link
     *              Character}, {@link Short}, {@link Integer} , {@link Long}, {@link Float}, {@link Double},
     *              {@link String} or {@link Type} of {@link Type#OBJECT} or {@link Type#ARRAY} sort. This
     *              value can also be an array of byte, boolean, short, char, int, long, float or double values
     *              (this is equivalent to using {@link #visitArray} and visiting each array element in turn,
     *              but is more convenient).
     */
    @Override
    public void visit(String name, Object value) {
//        log.info("注解的类型为 {}",value.getClass());
        // name != null ，说明注解的内容不会为数组
        if (null != name) {
            ebAnnContentInfo = new EbAnnContentInfo();
            ebAnnContentInfo.setName(name);
            ebAnnContentInfo.setAnnValueType(EbAnnContentInfo.AnnValueType.utf_8);
            ebAnnContentInfos.add(ebAnnContentInfo);
        }

        ebAnnContentInfo.getValues().add(value.toString());

        super.visit(name, value);
    }

    @Override
    public void visitEnum(String name, String descriptor, String value) {

        if (null != name) {
            ebAnnContentInfo = new EbAnnContentInfo();
            ebAnnContentInfo.setName(name);
            ebAnnContentInfo.setAnnValueType(EbAnnContentInfo.AnnValueType.enumx);
            ebAnnContentInfos.add(ebAnnContentInfo);
        }

        ebAnnContentInfo.setDescriptor(descriptor);
        ebAnnContentInfo.getValues().add(value.toString());

        super.visitEnum(name, descriptor, value);
    }


    @Override
    public AnnotationVisitor visitAnnotation(String name, String descriptor) {


        ebAlertInfo.setAlert("嵌套注解，逆天存在");


        return super.visitAnnotation(name, descriptor);
    }


    /**
     * 注解的值为 数组
     * 当注解的值为数组时，会访问一个新的 EbAnnotationVisitor ，进而访问 visit(String name, Object value) 方法
     * 但是在访问 visit(String name, Object value) 方法时，name 的值为 null，入参值不为 null。
     *
     * @param name the value name.
     * @return
     */
    @Override
    public AnnotationVisitor visitArray(String name) {

        if (null != name) {
            ebAnnContentInfo = new EbAnnContentInfo();
            ebAnnContentInfo.setName(name);

            ebAnnContentInfo.setAnnValueType(EbAnnContentInfo.AnnValueType.array);
            ebAnnContentInfos.add(ebAnnContentInfo);
        }

        EbAnnotationVisitor tempAnnVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnContentInfo, ebAlertInfo);
        return tempAnnVisitor;
    }

    @Override
    public void visitEnd() {
        if (ebAnnContentInfos != null) {
//            log.info("注解的结果为 {}", ebAnnContentInfos);
        }
        super.visitEnd();
    }
}
