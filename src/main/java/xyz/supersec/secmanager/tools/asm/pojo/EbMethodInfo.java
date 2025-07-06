package xyz.supersec.secmanager.tools.asm.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnLabelInfo;
import xyz.supersec.secmanager.db.entity.BcInsnMethodFrame;
import xyz.supersec.secmanager.db.entity.BcInsnTryCatchInfo;
import xyz.supersec.secmanager.db.entity.BcMethodInfo;
import xyz.supersec.secmanager.db.entity.BcMethodParameter;
import xyz.supersec.secmanager.db.entity.BcMethodVar;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInsnFlag;

@Data
@Accessors(chain = true)
public class EbMethodInfo extends BcMethodInfo  implements EbPojo{
    private List<BcMethodParameter> methodArgs = new ArrayList<>();
    private List<EbInsnFlag> ebInsns = new ArrayList<>();
    private List<BcInsnLabelInfo> insnLabelInfos = new ArrayList<>();
    private List<BcInsnTryCatchInfo> insnTryCatchInfos = new ArrayList<>();
    private List<EbAnnInfo> ebAnnInfos = new ArrayList<>();
    private List<BcMethodVar> bcMethodVars = new ArrayList<>();
    private List<BcInsnMethodFrame> bcInsnMethodFrames = new ArrayList<>();


    @Override
    public BcMethodInfo getDbPojo() {
        return this;
    }
}
