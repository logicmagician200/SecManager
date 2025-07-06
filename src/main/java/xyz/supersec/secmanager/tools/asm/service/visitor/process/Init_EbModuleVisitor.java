package xyz.supersec.secmanager.tools.asm.service.visitor.process;

import org.objectweb.asm.ModuleVisitor;

class Init_EbModuleVisitor extends ModuleVisitor {


    protected Init_EbModuleVisitor(int api) {
        super(api);
    }

    protected Init_EbModuleVisitor(int api, ModuleVisitor moduleVisitor) {
        super(api, moduleVisitor);
    }

    @Override
    public ModuleVisitor getDelegate() {
        return super.getDelegate();
    }

    @Override
    public void visitMainClass(String mainClass) {
        super.visitMainClass(mainClass);
    }

    @Override
    public void visitPackage(String packaze) {
        super.visitPackage(packaze);
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        super.visitRequire(module, access, version);
    }

    @Override
    public void visitExport(String packaze, int access, String... modules) {
        super.visitExport(packaze, access, modules);
    }

    @Override
    public void visitOpen(String packaze, int access, String... modules) {
        super.visitOpen(packaze, access, modules);
    }

    @Override
    public void visitUse(String service) {
        super.visitUse(service);
    }

    @Override
    public void visitProvide(String service, String... providers) {
        super.visitProvide(service, providers);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
