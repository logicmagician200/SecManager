package xyz.supersec.secmanager.tools.asm.pojo;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcFieldInfo;

@Data
@Accessors(chain = true)
@ToString
public class EbFieldInfo extends BcFieldInfo  implements EbPojo{
    private List<EbAnnInfo> ebAnnInfos = new ArrayList<>();


    @Override
    public BcFieldInfo getDbPojo() {
        return this;
    }
}
