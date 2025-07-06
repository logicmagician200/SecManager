package xyz.supersec.secmanager.tools.asm.service.visitor.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcAlertInfo;

@Data
@Accessors(chain = true)
@ToString(exclude = "alertInfos")
public class EbAlertInfo {
    // 项目id
    private int projectId;
    // 当前解析的类名
    private String className;
    // 当前解析的字段名
    private String fieldName;
    // 当前解析的方法名
    private String methodName;

    private List<BcAlertInfo> alertInfos = new ArrayList<>();
    public void onlySetFieldName(String fieldName) {
        this.fieldName=fieldName;
        this.methodName=null;

    }

    public void onlySetMethodName(String methodName) {
        this.methodName=methodName;
        this.fieldName = null;

    }




    /**
     * 通过 jvm 的堆栈生成警告信息的位置信息
     */
    public void setAlert(String alertInfo) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String location = stackTrace[2].toString();

        // 告警的位置信息
        location = locationUtil(location);

        String content = buildContent(alertInfo);

        BcAlertInfo info = new BcAlertInfo();
        info.setPId(projectId).setLocation(location).setTargetClass(className).setContent(content)
                .setDataFlag(EbStatus.create);

        alertInfos.add(info);

    }

    private String buildContent(String alertInfo) {
        String content = "";

        if (StringUtils.isNotBlank(fieldName)) {
            content += "目标字段：" + fieldName;
        }

        if (StringUtils.isNotBlank(methodName)) {
            content += "目标方法：" + methodName;
        }

        content += alertInfo;

        if (content.length() >= 350) {

            int length = content.length();
            content = content.substring(length - 350 + 1);

        }

        return content;
    }


    private String locationUtil(String location) {
        // 去掉前缀
        location = location.replaceFirst("explore.bytecode.service.visitor.", "");

        location = location.replaceFirst("\\(.*\\)", "");


        return location;
    }




    public static void main(String[] args) {
        EbAlertInfo ebAlertInfo1 = new EbAlertInfo();


    }

    public void setAlert(String s, int parameter, String descriptor) {
    }
}
