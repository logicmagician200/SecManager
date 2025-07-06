package xyz.supersec.secmanager.tools.asm.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EbProjectInfo {
    private int projectId;

    private String current_java_md5;
    private String current_class_md5;


}
