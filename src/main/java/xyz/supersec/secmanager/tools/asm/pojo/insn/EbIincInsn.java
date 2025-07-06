package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnIincInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbIincInsn extends BcInsnIincInsn implements EbPojo, EbInsnFlag {
    public final static String insnMethodType = "EbIincInsn";

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }


    @Override
    public BcInsnIincInsn getDbPojo() {
        return this;
    }
}
