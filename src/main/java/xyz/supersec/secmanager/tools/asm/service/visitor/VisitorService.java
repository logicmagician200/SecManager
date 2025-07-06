package xyz.supersec.secmanager.tools.asm.service.visitor;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.tools.asm.pojo.EbClassInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbProjectInfo;
import xyz.supersec.secmanager.tools.asm.service.visitor.process.VisitorInterface;


/**
 * 核心解析程序的入口，在 ASM 的解析逻辑中，只有这一个类由 Spring IOC 机制进行管理，其他的类都是使用 new 方式生成示例的。
 * <p>
 * 为什么这样设计?
 * 1，解析逻辑和插入逻辑完全解耦
 * 2，返回的内容并不是数据库对应的 pojo，方便修改解析逻辑
 * 3，插入数据库的逻辑完全由 InsertAllService 类负责。
 */

@Service
@Slf4j
public class VisitorService {


    /**
     * @param inputStream
     * @param ebProjectInfo
     * @return 返回解析出的当前类的所有内容
     * @throws Exception
     */
    public EbClassInfo parser(InputStream inputStream, EbProjectInfo ebProjectInfo) throws Exception {

        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);
        EbClassInfo ebClassInfo = visitorInterface.parserByInputStream(inputStream);

        log.info("开始插入解析的 ClassFile 信息");

        return ebClassInfo;
    }

    /**
     * @param clazz
     * @param ebProjectInfo
     * @return 返回解析出的当前类的所有内容
     * @throws Exception
     */
    public EbClassInfo parser(Class clazz, EbProjectInfo ebProjectInfo) throws Exception {
        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);

        EbClassInfo ebClassInfo = visitorInterface.parserByClass(clazz);

        return ebClassInfo;
    }

    /**
     * @param path
     * @param ebProjectInfo
     * @return 返回解析出的当前类的所有内容
     * @throws Exception
     */
    public EbClassInfo parser(String path, EbProjectInfo ebProjectInfo) throws Exception {


        VisitorInterface visitorInterface = new VisitorInterface(ebProjectInfo);
        EbClassInfo ebClassInfo = visitorInterface.parserPath(path);
        ebClassInfo.setJavaMd5(ebProjectInfo.getCurrent_java_md5());


        return ebClassInfo;
    }


}
