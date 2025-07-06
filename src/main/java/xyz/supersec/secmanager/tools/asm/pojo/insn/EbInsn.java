package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbInsn extends BcInsnInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbInsn";
    @Override
    public BcInsnInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
