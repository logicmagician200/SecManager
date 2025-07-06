package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnIntInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbIntInsn extends BcInsnIntInsn implements EbPojo,EbInsnFlag {
    public final static String insnMethodType = "EbIntInsn";

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
    @Override
    public BcInsnIntInsn getDbPojo() {
        return this;
    }
}
