package xyz.supersec.secmanager.tools.asm.pojo;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcAlertInfo;
import xyz.supersec.secmanager.db.entity.BcClassInfo;
import xyz.supersec.secmanager.db.entity.BcInnerClassInfo;
import xyz.supersec.secmanager.db.entity.BcRecordComponentInfo;

/**
 * 存放一个 class 文件解析出的所有内容
 */
@Data
@Accessors(chain = true)
@ToString
public class EbClassInfo extends BcClassInfo  implements EbPojo{

    private List<EbMethodInfo> ebMethodInfos = new ArrayList<>();
    private List<EbFieldInfo> ebFieldInfos = new ArrayList<>();
    private List<BcInnerClassInfo> innerClassInfos = new ArrayList<>();
    private List<BcRecordComponentInfo> recordComponentInfos = new ArrayList<>();
    private List<EbAnnInfo> ebAnnInfos = new ArrayList<>();
    private List<BcAlertInfo> alertInfos;


    @Override
    public BcClassInfo getDbPojo() {
        return this;
    }
}
