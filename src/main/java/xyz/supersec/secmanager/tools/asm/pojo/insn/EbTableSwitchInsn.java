package xyz.supersec.secmanager.tools.asm.pojo.insn;



import java.util.Arrays;
import java.util.List;

import org.objectweb.asm.Label;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnTableSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbTableSwitchInsn extends BcInsnTableSwitchInsn implements EbPojo,EbInsnFlag {
    public final static String insnMethodType = "EbTableSwitchInsn";
    private Label dflt_eb;
    private Label[] labels_eb;
    @Override
    public BcInsnTableSwitchInsn getDbPojo() {

        if (dflt_eb != null) {
            setDflt(dflt_eb.toString());
        }
        if (labels_eb != null) {
            List<Label> labels = Arrays.stream(labels_eb).toList();
            setLabels(labels.toString());
        }

        return this;
    }

    @Override
    public String getInsnMethodType() {
        return insnMethodType;
    }
}
