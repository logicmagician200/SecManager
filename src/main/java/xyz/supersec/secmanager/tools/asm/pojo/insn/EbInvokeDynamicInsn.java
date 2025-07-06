package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnInvokeDynamicInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbInvokeDynamicInsn extends BcInsnInvokeDynamicInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbInvokeDynamicInsn";

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
    @Override
    public BcInsnInvokeDynamicInsn getDbPojo() {
        return this;
    }
}
