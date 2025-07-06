package xyz.supersec.secmanager.tools.asm.service.visitor.process;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;

class Init_EbRecordComponentVisitor extends RecordComponentVisitor {
    protected Init_EbRecordComponentVisitor(int api) {
        super(api);
    }

    protected Init_EbRecordComponentVisitor(int api, RecordComponentVisitor recordComponentVisitor) {
        super(api, recordComponentVisitor);
    }

    @Override
    public RecordComponentVisitor getDelegate() {
        return super.getDelegate();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        return super.visitAnnotation(descriptor, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
