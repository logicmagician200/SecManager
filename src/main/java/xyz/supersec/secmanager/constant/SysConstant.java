package xyz.supersec.secmanager.constant;

public class SysConstant {

    public static String getWorkDir() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "C:\\workdir\\";
        } else if (os.contains("mac")) {
            return "/Users/workdir/";
        } else {
            // 默认返回Linux或其他操作系统的工作目录
            return "/home/workdir/";
        }
    }


}
