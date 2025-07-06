package xyz.supersec.secmanager.tools.asm.pojo.insn;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.objectweb.asm.Label;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcInsnLookupSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.EbPojo;

@Data
@Accessors(chain = true)
@ToString
public class EbLookupSwitchInsn extends BcInsnLookupSwitchInsn implements EbPojo, EbInsnFlag {
    public final static String insnMethodType = "EbLookupSwitchInsn";
    private Label dflt_eb;
    private int[] keys_eb;
    private Label[] labels_eb;

    @Override
    public BcInsnLookupSwitchInsn getDbPojo() {
        if (dflt_eb != null) {
            setDflt(dflt_eb.toString());
        }
        if (keys_eb != null) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < keys_eb.length; i++) {
                result.add(keys_eb[i]);
            }
            List<Integer> collect = result.stream().collect(Collectors.toList());
            setKeysStr(collect.toString());
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
