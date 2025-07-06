package xyz.supersec.secmanager.tools.asm.service.visitor.process;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.util.Printer;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.db.entity.BcInsnLabelInfo;
import xyz.supersec.secmanager.db.entity.BcInsnMethodFrame;
import xyz.supersec.secmanager.db.entity.BcInsnTryCatchInfo;
import xyz.supersec.secmanager.db.entity.BcMethodParameter;
import xyz.supersec.secmanager.db.entity.BcMethodVar;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbMethodInfo;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbFieldInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbIincInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbIntInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInvokeDynamicInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbJumpInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbLdcInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbLookupSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbMethodInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbMultiANewArrayInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbTableSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbTypeInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbVarInsn;
import xyz.supersec.secmanager.tools.asm.service.common.Acc_utils;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAlertInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbAnnTarget;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbStatus;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbUtils;

@Slf4j
class EbMethodVisitor extends MethodVisitor {

    // 用来标记当前指令的指针
    private int insnIndex = 0;
    // 当前指令在源代码中对应的行
    private int source_line = 0;

    // 方法参数的指针，用来标明参数在方法中的位置
    private int ages_index = 0;

    private EbMethodInfo ebMethodInfo;
    private EbAlertInfo ebAlertInfo;

    private BcInsnLabelInfo insnLabelInfo = null;


    protected EbMethodVisitor(int api, EbMethodInfo ebMethodInfo, EbAlertInfo ebAlertInfo) {
        super(api);
        this.ebMethodInfo = ebMethodInfo;
        this.ebAlertInfo = ebAlertInfo;
    }

    @Override
    public MethodVisitor getDelegate() {
        return super.getDelegate();
    }


    /**
     * 特别说明：并不是访问 class 文件中的每个方法都会使用此方法，具体调用此方法的逻辑有待确定
     * 不论目标方法是不是静态的，都不会包含 this，
     * 因此在此规定  方法的指针从 1 开始。
     *
     * @param the parameter's access flags, only ACC_FINAL, ACC_SYNTHETIC or/and ACC_MANDATED are allowed (see Opcodes).
     * @name
     */
    @Override
    public void visitParameter(String name, int access) {
        log.info("visitParameter ,name = {} ", name);
        BcMethodParameter methodArgs = new BcMethodParameter();
        methodArgs.setMethodUuid(ebMethodInfo.getUuid()).setArgIndex(++ages_index).setName(name)
                .setAccess(EbUtils.getACC(access))
                .setAccessFlag(Acc_utils.parameter_acc(access))
                .setDataFlag(EbStatus.ok);

        ebMethodInfo.getMethodArgs().add(methodArgs);

        super.visitParameter(name, access);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        log.info("visitAnnotationDefault");
        ebAlertInfo.setAlert("方法的默认注解");

        /**
         * 和注解相关的，具体处理逻辑待定
         */

        return super.visitAnnotationDefault();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        log.info("visitAnnotation 描述符为 {}", descriptor);

        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTargetType(EbAnnTarget.method.toString()).setTargetUuid(ebMethodInfo.getUuid())
                .setPId(ebAlertInfo.getProjectId()).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;
    }


    /**
     * @param typeRef
     * @param typePath
     * @param descriptor
     * @param visible
     * @return
     */
    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        log.info("visitTypeAnnotation 描述符为 typeRef= {}，typePath = {}，descriptor = {}", typeRef, typePath, descriptor);
        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setTypeRef(typeRef).setTypePath(typePath != null ? typePath.toString() : "")
                .setTargetType(EbAnnTarget.method.toString()).setTargetUuid(ebMethodInfo.getUuid())
                .setPId(ebAlertInfo.getProjectId())
                .setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;
    }

    /**
     * 方法入参注解的个数，所有入参注解的总和。
     * <p>
     * 初步判断，每个方法最多调用两次 visitAnnotableParameterCount 方法，根据 visible 的值不同来判断。
     * <p>
     * 方法调用顺序 visitAnnotableParameterCount --> visitParameterAnnotation
     */
    @Override
    public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
        log.info("visitAnnotableParameterCount parameterCount为 {} visible = {}", parameterCount, visible);
        ebAlertInfo.setAlert("方法注解注解的数目");
        /**
         * 和注解相关的，具体处理逻辑待定
         */

        super.visitAnnotableParameterCount(parameterCount, visible);
    }

    /**
     * 方法方法入参的注解
     *
     * @param parameter  方法可见入参的指针，从 0 开始，即第一个可见入参的 指针为 0.
     * @param descriptor the class descriptor of the annotation class.
     * @param visible    {@literal true} if the annotation is visible at runtime.
     * @return
     */
    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String descriptor, boolean visible) {
        log.info("visitParameterAnnotation parameter = {} , descriptor = {}", parameter, descriptor);

        EbAnnInfo ebAnnInfo = new EbAnnInfo();
        ebAnnInfo.setDescriptor(descriptor).setVisible(Boolean.toString(visible))
                .setParamIndex(parameter).setTargetType(EbAnnTarget.method.toString())
                .setTargetUuid(ebMethodInfo.getUuid()).setPId(ebAlertInfo.getProjectId())
                .setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbAnnInfos().add(ebAnnInfo);

        EbAnnotationVisitor ebAnnotationVisitor = new EbAnnotationVisitor(EbUtils.ASM_version, ebAnnInfo.getEbAnnContentInfos(), ebAlertInfo);
        return ebAnnotationVisitor;

    }

    @Override
    public void visitAttribute(Attribute attribute) {
        log.info("visitAttribute = {}", attribute.toString());
        ebAlertInfo.setAlert("方法自定义属性");

        String str = attribute + "$$";
        ebMethodInfo.setAttribute(ebMethodInfo.getAttribute() + str);

        super.visitAttribute(attribute);
    }

    @Override
    public void visitCode() {
        log.info("开始访问 visitCode");
        insnIndex = 0;

        super.visitCode();
    }


    /**
     * 初步判断此方法中的内容和 Code 属性中的 StackMapTable 属性有关。
     */
    @Override
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        log.info("visitFrame type = {} , numLocal = {} ,numStack = {}", type, numLocal, numStack);

        BcInsnMethodFrame bcInsnMethodFrame = new BcInsnMethodFrame();
        bcInsnMethodFrame
                .setMethodUuid(ebMethodInfo.getUuid())
                .setLabel(this.insnLabelInfo.getLabel())
                .setSourceLine(this.insnLabelInfo.getSourceLine())
                .setType(type)
                .setNumLocal(numLocal)
                .setNumStack(numStack);

        if (local != null) {
            List<Object> locals = Arrays.stream(local).collect(Collectors.toList());
            bcInsnMethodFrame.setLocal(locals.toString());
        }
        if (stack != null) {
            List<Object> stacks = Arrays.stream(stack).collect(Collectors.toList());
            bcInsnMethodFrame.setStack(stacks.toString());
        }


        ebMethodInfo.getBcInsnMethodFrames().add(bcInsnMethodFrame);

        super.visitFrame(type, numLocal, local, numStack, stack);
    }

    @Override
    public void visitInsn(int opcode) {

        EbInsn insn = new EbInsn();
        insn.setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(insn);

        super.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        EbIntInsn intInsn = new EbIntInsn();

        intInsn.setOperand(operand).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(intInsn);

        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int varIndex) {
        EbVarInsn varInsn = new EbVarInsn();

        varInsn.setVarIndex(varIndex).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(varInsn);

        super.visitVarInsn(opcode, varIndex);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        EbTypeInsn typeInsn = new EbTypeInsn();

        typeInsn.setType(type).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(typeInsn);

        super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {

        EbFieldInsn fieldInsn = new EbFieldInsn();
        fieldInsn.setOwner(owner).setName(name).setDescriptor(descriptor).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(fieldInsn);

        super.visitFieldInsn(opcode, owner, name, descriptor);
    }


    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {

        EbMethodInsn methodInsn = new EbMethodInsn();

        methodInsn.setOwner(owner).setName(name).setDescriptor(descriptor).setIsInterface(Boolean.toString(isInterface)).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(methodInsn);

        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {

        EbInvokeDynamicInsn invokeDynamicInsn = new EbInvokeDynamicInsn();


        invokeDynamicInsn.setName(name).setDescriptor(descriptor).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.INVOKEDYNAMIC].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        if (null != bootstrapMethodArguments) {
            invokeDynamicInsn.setHandleTag(bootstrapMethodHandle.getTag()).setHandleOwner(bootstrapMethodHandle.getOwner()).setHandleName(bootstrapMethodHandle.getName()).setHandleDescriptor(bootstrapMethodHandle.getDesc()).setHandleIsInterface(Boolean.toString(bootstrapMethodHandle.isInterface()));
        }

        if (!(null == bootstrapMethodArguments || 0 == bootstrapMethodArguments.length)) {
            invokeDynamicInsn.setMethodArgs(Arrays.stream(bootstrapMethodArguments).collect(Collectors.toList()).toString());
        }

        ebMethodInfo.getEbInsns().add(invokeDynamicInsn);

        super.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        EbJumpInsn jumpInsn = new EbJumpInsn();

        jumpInsn.setLabel(label.toString()).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[opcode].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(jumpInsn);

        super.visitJumpInsn(opcode, label);
    }

    /**
     * 遗留一个问题，
     * 当 只访问 visitLabel 方法而不访问 visitLineNumber 方法时
     * 这样会导致 source_line 值没有更新，不确定对行号的准确性是否有影响。
     */
    @Override
    public void visitLabel(Label label) {
        log.info("visitLabel {}", label.toString());
        this.insnLabelInfo = new BcInsnLabelInfo();
        insnLabelInfo.setMethodUuid(ebMethodInfo.getUuid()).setLabel(label.toString());

        ebMethodInfo.getInsnLabelInfos().add(insnLabelInfo);

        super.visitLabel(label);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        log.info("visitLineNumber {}  {}", line, start.toString());

        this.insnLabelInfo.setSourceLine(line).setDataFlag(EbStatus.ok);

        this.source_line = line;

        super.visitLineNumber(line, start);
    }

    @Override
    public void visitLdcInsn(Object value) {

        EbLdcInsn ldcInsn = new EbLdcInsn();

        ldcInsn.setValue(value.toString()).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.LDC].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(ldcInsn);

        super.visitLdcInsn(value);
    }

    @Override
    public void visitIincInsn(int varIndex, int increment) {
        EbIincInsn iincInsn = new EbIincInsn();

        iincInsn.setVarIndex(varIndex).setIncrement(increment).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.IINC].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(iincInsn);

        super.visitIincInsn(varIndex, increment);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {

        EbTableSwitchInsn tableSwitchInsn = new EbTableSwitchInsn();

        tableSwitchInsn.setDflt_eb(dflt).setLabels_eb(labels).setMin(min).setMax(max).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.TABLESWITCH].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line);


        ebMethodInfo.getEbInsns().add(tableSwitchInsn);

        super.visitTableSwitchInsn(min, max, dflt, labels);
    }


    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {

        EbLookupSwitchInsn lookupSwitchInsn = new EbLookupSwitchInsn();

        lookupSwitchInsn.setDflt_eb(dflt).setKeys_eb(keys).setLabels_eb(labels).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.LOOKUPSWITCH].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(lookupSwitchInsn);

        super.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        EbMultiANewArrayInsn multiANewArrayInsn = new EbMultiANewArrayInsn();

        multiANewArrayInsn.setDescriptor(descriptor).setNumDimensions(numDimensions).setMethodUuid(ebMethodInfo.getUuid()).setOpcode(Printer.OPCODES[Opcodes.MULTIANEWARRAY].toLowerCase()).setInsnIndex(++insnIndex).setSourceLine(source_line).setDataFlag(EbStatus.ok);

        ebMethodInfo.getEbInsns().add(multiANewArrayInsn);

        super.visitMultiANewArrayInsn(descriptor, numDimensions);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        log.info("visitInsnAnnotation descriptor = {}", descriptor);
        return super.visitInsnAnnotation(typeRef, typePath, descriptor, visible);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        log.info("visitTryCatchBlock");
        BcInsnTryCatchInfo insnTryCatchInfo = new BcInsnTryCatchInfo();
        insnTryCatchInfo.setMethodUuid(ebMethodInfo.getUuid()).setStartLabel(start.toString()).setEndLabel(end.toString()).setHandlerLabel(handler.toString()).setType(type).setDataFlag(EbStatus.ok);

        ebMethodInfo.getInsnTryCatchInfos().add(insnTryCatchInfo);

        super.visitTryCatchBlock(start, end, handler, type);
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        log.info("visitTryCatchAnnotation descriptor = {}", descriptor);
        ebAlertInfo.setAlert("方法中 tryCatch 的注解");

        /**
         * 和注解相关的，具体处理逻辑待定
         */

        return super.visitTryCatchAnnotation(typeRef, typePath, descriptor, visible);
    }

    /**
     * 方法方法中所有的 局部变量
     * 包括方法的入参和方法体中定义的局部变量
     * index 从 0 开始
     */
    @Override
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        log.info("visitLocalVariable {} --- {} --- {}", name, descriptor, signature);
        Date date = new Date();
        BcMethodVar methodVar = new BcMethodVar();
        methodVar.setMethodUuid(ebMethodInfo.getUuid()).setVarName(name).setDescriptor(descriptor).setSignature(signature).setStartLabel(start.toString()).setEndLabel(end.toString()).setVarIndex(index).setUpdateTime(date).setCreateTime(date);

        ebMethodInfo.getBcMethodVars().add(methodVar);


        super.visitLocalVariable(name, descriptor, signature, start, end, index);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
        log.info("visitLocalVariableAnnotation typeRef = {} , descriptor = {}", typeRef, descriptor);
        ebAlertInfo.setAlert("方法本地变量的注解");
        /**
         * 和局部变量的注解有关，此方法和 visitLocalVariable 可以同时开发。
         */
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, descriptor, visible);
    }


    /**
     * maxStack 和 maxLocals 被存储在 Code 属性中
     *
     * @param maxStack  maximum stack 当前方法的栈的最大深度
     * @param maxLocals maximum number 当前方法局部变量表的最大容器
     */
    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        log.info("visitMaxs {} {}", maxStack, maxLocals);
        ebMethodInfo.setMaxStack(maxStack).setMaxLocals(maxLocals);

        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        log.info("visitEnd 此方法结束");
        ebMethodInfo.setDataFlag(EbStatus.ok);


        super.visitEnd();
    }
}
