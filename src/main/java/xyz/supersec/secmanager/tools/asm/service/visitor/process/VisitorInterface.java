package xyz.supersec.secmanager.tools.asm.service.visitor.process;

import java.io.File;
import java.io.InputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.tools.asm.pojo.EbClassInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbProjectInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.util.EbUtils;

/**
 * 解析 Visitor 对外的接口
 */
@Slf4j
public class VisitorInterface {
    private EbProjectInfo ebProjectInfo;

    public VisitorInterface(EbProjectInfo ebProjectInfo) {
        this.ebProjectInfo = ebProjectInfo;
    }

    public EbClassInfo parserByInputStream(InputStream inputStream) throws Exception {
        EbClassInfo ebClassInfo =(EbClassInfo) new EbClassInfo().setPId(ebProjectInfo.getProjectId());
        EbClassVisitor ebClassVisitor = new EbClassVisitor(EbUtils.ASM_version, ebClassInfo);

        ClassReader classReader = new ClassReader(inputStream);
        classReader.accept(ebClassVisitor, ClassReader.EXPAND_FRAMES);


        return ebClassInfo;
    }

    public EbClassInfo parserByClass(Class clazz) throws Exception {
        EbClassInfo ebClassInfo = (EbClassInfo) new EbClassInfo().setPId(1);
        EbClassVisitor ebClassVisitor = new EbClassVisitor(EbUtils.ASM_version, ebClassInfo);

        String internalName = Type.getInternalName(clazz);

        ClassReader classReader = new ClassReader(internalName);
        classReader.accept(ebClassVisitor, ClassReader.EXPAND_FRAMES);


        return ebClassInfo;
    }

    public EbClassInfo parserPath(String path) throws Exception {
        File file = new File(path);

        EbClassInfo ebClassInfo = (EbClassInfo)new EbClassInfo().setPId(1);
        EbClassVisitor ebClassVisitor = new EbClassVisitor(EbUtils.ASM_version, ebClassInfo);

        ClassReader classReader = new ClassReader(FileUtils.readFileToByteArray(file));

        classReader.accept(ebClassVisitor, ClassReader.EXPAND_FRAMES);


        return ebClassInfo;
    }
}
