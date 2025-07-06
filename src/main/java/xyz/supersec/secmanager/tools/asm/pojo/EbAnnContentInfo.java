package xyz.supersec.secmanager.tools.asm.pojo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.supersec.secmanager.db.entity.BcAnnContent;

@Data
@Accessors(chain = true)
@ToString
public class EbAnnContentInfo extends BcAnnContent implements EbPojo {

    private List<String> values = new ArrayList<>();


    private AnnValueType annValueType;

    @Override
    public BcAnnContent getDbPojo() {

        String values_str = values.stream().collect(Collectors.toList()).toString();
        this.setValue(values_str);

        return this;
    }


    public enum AnnValueType {
        array, enumx, utf_8
    }
}
