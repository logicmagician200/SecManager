package xyz.supersec.secmanager.tools.asm.pojo;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcAnnInfo;

@Data
@Accessors(chain = true)
@ToString
public class EbAnnInfo extends BcAnnInfo  implements EbPojo{
    private List<EbAnnContentInfo> ebAnnContentInfos = new ArrayList<>();


    @Override
    public BcAnnInfo getDbPojo() {
        return this;
    }
}
