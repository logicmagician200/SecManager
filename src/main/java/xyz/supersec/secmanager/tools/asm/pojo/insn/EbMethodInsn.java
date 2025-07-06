package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnMethodInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbMethodInsn extends BcInsnMethodInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbMethodInsn";
    @Override
    public BcInsnMethodInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
