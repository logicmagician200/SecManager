package xyz.supersec.secmanager.tools.asm.pojo.insn;



import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnLdcInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbLdcInsn extends BcInsnLdcInsn implements EbPojo,EbInsnFlag {
    public final static String insnMethodType = "EbLdcInsn";
    @Override
    public BcInsnLdcInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
