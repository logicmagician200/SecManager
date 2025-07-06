package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnFieldInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbFieldInsn extends BcInsnFieldInsn implements EbPojo,EbInsnFlag {
    public final static String insnMethodType = "EbFieldInsn";

    @Override
    public BcInsnFieldInsn getDbPojo() {

        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
