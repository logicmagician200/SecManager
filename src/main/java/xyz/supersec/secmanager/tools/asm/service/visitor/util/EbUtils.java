package xyz.supersec.secmanager.tools.asm.service.visitor.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.Opcodes;
import org.springframework.util.DigestUtils;

public class EbUtils {

    public final static int ASM_version = Opcodes.ASM9;

    private final static Map<Integer, Map<EbAccTargetType, String>> opcodeMap = initOpcode();


    public static String md5(String str) {


        String digestAsHex = DigestUtils.md5DigestAsHex(str.getBytes(Charset.forName("utf-8")));


        return digestAsHex;
    }


    /**
     * @param opcode
     * @return
     */
    public static String getACC(int opcode) {


        String result = Integer.toString(opcode);


        return result;
    }

    public static void main(String[] args) {



    }
    public static String getFileMd5(String path) {

        String result = "";
        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);

            result = DigestUtils.md5DigestAsHex(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    private static Map<Integer, Map<EbAccTargetType, String>> initOpcode() {
        Map<Integer, Map<EbAccTargetType, String>> map = new HashMap<>();

        Map<EbAccTargetType, String> pub = new HashMap<>();
        pub.put(EbAccTargetType.defaultType, "pub");
        map.put(0x0001, pub);

        Map<EbAccTargetType, String> pri = new HashMap<>();
        pri.put(EbAccTargetType.defaultType, "pri");
        map.put(0x0002, pri);

        Map<EbAccTargetType, String> pro = new HashMap<>();
        pro.put(EbAccTargetType.defaultType, "pro");
        map.put(0x0004, pro);

        Map<EbAccTargetType, String> staC = new HashMap<>();
        staC.put(EbAccTargetType.defaultType, "staC");
        map.put(0x0008, staC);

        Map<EbAccTargetType, String> fin = new HashMap<>();
        fin.put(EbAccTargetType.defaultType, "fin");
        map.put(0x0010, fin);


        Map<EbAccTargetType, String> sup = new HashMap<>();
        sup.put(EbAccTargetType.clazz, "sup");
        sup.put(EbAccTargetType.method, "sync");
        sup.put(EbAccTargetType.module, "ope");
        sup.put(EbAccTargetType.defaultType, "traE");
        map.put(0x0020, sup);

        return map;
    }


}
