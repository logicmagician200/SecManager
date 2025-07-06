package xyz.supersec.secmanager.tools.asm.pojo.insn;



import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnMultiAnewArrayInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbMultiANewArrayInsn extends BcInsnMultiAnewArrayInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbMultiANewArrayInsn";
    @Override
    public BcInsnMultiAnewArrayInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
