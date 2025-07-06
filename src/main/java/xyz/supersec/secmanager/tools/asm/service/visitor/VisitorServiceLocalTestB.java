package xyz.supersec.secmanager.tools.asm.service.visitor;

import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.tools.asm.pojo.EbClassInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbProjectInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.process.VisitorInterface;

@Slf4j
public class VisitorServiceLocalTestB {
    public static void main(String[] args) throws Exception {
        log.info("程序开始********************");

        VisitorServiceLocalTestB visitorServiceTestB = new VisitorServiceLocalTestB();
        String path = "C:\\Users\\lenovo\\Desktop\\test622\\explore";
        visitorServiceTestB.parse(path, getProjectInfo());

    }

    private EbClassInfo parse(InputStream inputStream, EbProjectInfo ebProjectInfo) throws Exception {

        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);
        EbClassInfo ebClassInfo = visitorInterface.parserByInputStream(inputStream);

        log.info("开始插入解析的 ClassFile 信息");

        return ebClassInfo;
    }

    private EbClassInfo parse(Class clazz, EbProjectInfo ebProjectInfo) throws Exception {
        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);

        EbClassInfo ebClassInfo = visitorInterface.parserByClass(clazz);

        return ebClassInfo;
    }

    private EbClassInfo parse(String path, EbProjectInfo ebProjectInfo) throws Exception {

        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);
        EbClassInfo ebClassInfo = visitorInterface.parserPath(path);

        return ebClassInfo;
    }


    private static EbProjectInfo getProjectInfo() {
        EbProjectInfo info = new EbProjectInfo();
        info.setProjectId(2);
        return info;
    }

}
