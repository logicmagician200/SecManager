package xyz.supersec.secmanager.tools.asm.pojo.insn;


import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnVarInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbVarInsn extends BcInsnVarInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbVarInsn";

    @Override
    public BcInsnVarInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
