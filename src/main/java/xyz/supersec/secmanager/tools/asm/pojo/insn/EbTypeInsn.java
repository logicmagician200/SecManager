package xyz.supersec.secmanager.tools.asm.pojo.insn;




import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnTypeInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbTypeInsn extends BcInsnTypeInsn implements EbPojo ,EbInsnFlag{
    public final static String insnMethodType = "EbTypeInsn";

    @Override
    public BcInsnTypeInsn getDbPojo() {
        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
