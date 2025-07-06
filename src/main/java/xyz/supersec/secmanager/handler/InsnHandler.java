package xyz.supersec.secmanager.handler;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.supersec.secmanager.db.entity.BcInsnFieldInsn;
import xyz.supersec.secmanager.db.entity.BcInsnIincInsn;
import xyz.supersec.secmanager.db.entity.BcInsnInsn;
import xyz.supersec.secmanager.db.entity.BcInsnIntInsn;
import xyz.supersec.secmanager.db.entity.BcInsnInvokeDynamicInsn;
import xyz.supersec.secmanager.db.entity.BcInsnJumpInsn;
import xyz.supersec.secmanager.db.entity.BcInsnLdcInsn;
import xyz.supersec.secmanager.db.entity.BcInsnLookupSwitchInsn;
import xyz.supersec.secmanager.db.entity.BcInsnMethodInsn;
import xyz.supersec.secmanager.db.entity.BcInsnMultiAnewArrayInsn;
import xyz.supersec.secmanager.db.entity.BcInsnTableSwitchInsn;
import xyz.supersec.secmanager.db.entity.BcInsnTypeInsn;
import xyz.supersec.secmanager.db.entity.BcInsnVarInsn;
import xyz.supersec.secmanager.db.service.IBcInsnFieldInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnIincInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnIntInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnInvokeDynamicInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnJumpInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnLdcInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnLookupSwitchInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnMethodInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnMultiAnewArrayInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnTableSwitchInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnTypeInsnService;
import xyz.supersec.secmanager.db.service.IBcInsnVarInsnService;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbFieldInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbIincInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInsnFlag;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbIntInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbInvokeDynamicInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbJumpInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbLdcInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbLookupSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbMethodInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbMultiANewArrayInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbTableSwitchInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbTypeInsn;
import xyz.supersec.secmanager.tools.asm.pojo.insn.EbVarInsn;

@Service
public class InsnHandler {

    @Autowired
    private IBcInsnFieldInsnService bcInsnFieldInsnService;
    @Autowired
    private IBcInsnIincInsnService bcInsnIincInsnService;
    @Autowired
    private IBcInsnInsnService bcInsnInsnService;
    @Autowired
    private IBcInsnIntInsnService bcInsnIntInsnService;
    @Autowired
    private IBcInsnInvokeDynamicInsnService bcInsnInvokeDynamicInsnService;
    @Autowired
    private IBcInsnJumpInsnService bcInsnJumpInsnService;
    @Autowired
    private IBcInsnLdcInsnService bcInsnLdcInsnService;
    @Autowired
    private IBcInsnLookupSwitchInsnService bcInsnLookupSwitchInsnService;
    @Autowired
    private IBcInsnMethodInsnService bcInsnMethodInsnService;
    @Autowired
    private IBcInsnMultiAnewArrayInsnService bcInsnMultiAnewArrayInsnService;
    @Autowired
    private IBcInsnTableSwitchInsnService bcInsnTableSwitchInsnService;
    @Autowired
    private IBcInsnTypeInsnService bcInsnTypeInsnService;
    @Autowired
    private IBcInsnVarInsnService bcInsnVarInsnService;

    public void saveEbInsnFlags(List<EbInsnFlag> ebInsnFlags) {

        Map<String, List<EbInsnFlag>> allInsn = ebInsnFlags.stream().collect(Collectors.groupingBy(EbInsnFlag::getInsnMethodType));

        if (allInsn.get(EbFieldInsn.insnMethodType) != null) {
            List<BcInsnFieldInsn> bcInsnFieldInsns = allInsn.get(EbFieldInsn.insnMethodType).stream().map(x -> (EbFieldInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnFieldInsnService.saveBatch(bcInsnFieldInsns);
        }

        if (allInsn.get(EbIincInsn.insnMethodType) != null) {
            List<BcInsnIincInsn> bcInsnIincInsns = allInsn.get(EbIincInsn.insnMethodType).stream().map(x -> (EbIincInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnIincInsnService.saveBatch(bcInsnIincInsns);
        }

        if (allInsn.get(EbInsn.insnMethodType) != null) {
            List<BcInsnInsn> bcInsnInsns = allInsn.get(EbInsn.insnMethodType).stream().map(x -> (EbInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnInsnService.saveBatch(bcInsnInsns);
        }

        if (allInsn.get(EbIntInsn.insnMethodType) != null) {
            List<BcInsnIntInsn> bcInsnIntInsns = allInsn.get(EbIntInsn.insnMethodType).stream().map(x -> (EbIntInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnIntInsnService.saveBatch(bcInsnIntInsns);
        }

        if (allInsn.get(EbInvokeDynamicInsn.insnMethodType) != null) {
            List<BcInsnInvokeDynamicInsn> bcInsnInvokeDynamicInsns = allInsn.get(EbInvokeDynamicInsn.insnMethodType).stream().map(x -> (EbInvokeDynamicInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnInvokeDynamicInsnService.saveBatch(bcInsnInvokeDynamicInsns);
        }

        if (allInsn.get(EbJumpInsn.insnMethodType) != null) {
            List<BcInsnJumpInsn> bcInsnJumpInsns = allInsn.get(EbJumpInsn.insnMethodType).stream().map(x -> (EbJumpInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnJumpInsnService.saveBatch(bcInsnJumpInsns);
        }

        if (allInsn.get(EbLdcInsn.insnMethodType) != null) {
            List<BcInsnLdcInsn> bcInsnLdcInsns = allInsn.get(EbLdcInsn.insnMethodType).stream().map(x -> (EbLdcInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnLdcInsnService.saveBatch(bcInsnLdcInsns);
        }

        if (allInsn.get(EbLookupSwitchInsn.insnMethodType) != null) {
            List<BcInsnLookupSwitchInsn> bcInsnLookupSwitchInsns = allInsn.get(EbLookupSwitchInsn.insnMethodType).stream().map(x -> (EbLookupSwitchInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnLookupSwitchInsnService.saveBatch(bcInsnLookupSwitchInsns);
        }

        if (allInsn.get(EbMethodInsn.insnMethodType) != null) {
            List<BcInsnMethodInsn> bcInsnMethodInsns = allInsn.get(EbMethodInsn.insnMethodType).stream().map(x -> (EbMethodInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnMethodInsnService.saveBatch(bcInsnMethodInsns);
        }

        if (allInsn.get(EbMultiANewArrayInsn.insnMethodType) != null) {
            List<BcInsnMultiAnewArrayInsn> bcInsnMultiAnewArrayInsns = allInsn.get(EbMultiANewArrayInsn.insnMethodType).stream().map(x -> (EbMultiANewArrayInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnMultiAnewArrayInsnService.saveBatch(bcInsnMultiAnewArrayInsns);
        }

        if (allInsn.get(EbTableSwitchInsn.insnMethodType) != null) {
            List<BcInsnTableSwitchInsn> bcInsnTableSwitchInsns = allInsn.get(EbTableSwitchInsn.insnMethodType).stream().map(x -> (EbTableSwitchInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnTableSwitchInsnService.saveBatch(bcInsnTableSwitchInsns);
        }

        if (allInsn.get(EbTypeInsn.insnMethodType) != null) {
            List<BcInsnTypeInsn> bcInsnTypeInsns = allInsn.get(EbTypeInsn.insnMethodType).stream().map(x -> (EbTypeInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnTypeInsnService.saveBatch(bcInsnTypeInsns);
        }

        if (allInsn.get(EbVarInsn.insnMethodType) != null) {
            List<BcInsnVarInsn> bcInsnVarInsns = allInsn.get(EbVarInsn.insnMethodType).stream().map(x -> (EbVarInsn) x).map(x -> x.getDbPojo()).collect(Collectors.toList());
            bcInsnVarInsnService.saveBatch(bcInsnVarInsns);
        }

    }

    // public AllInsns methodSubInsn(String method_uuid, int start_insn_index, int end_insn_index) {
    //     AllInsns allInsns = new AllInsns();

    //     List<BcInsnFieldInsn> bcInsnFieldInsns = bcInsnFieldInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnFieldInsns().addAll(bcInsnFieldInsns);

    //     List<BcInsnIincInsn> bcInsnIincInsns = bcInsnIincInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnIincInsns().addAll(bcInsnIincInsns);

    //     List<BcInsnInsn> bcInsnInsns = bcInsnInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnInsns().addAll(bcInsnInsns);

    //     List<BcInsnIntInsn> bcInsnIntInsns = bcInsnIntInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnIntInsns().addAll(bcInsnIntInsns);

    //     List<BcInsnInvokeDynamicInsn> bcInsnInvokeDynamicInsns = bcInsnInvokeDynamicInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnInvokeDynamicInsns().addAll(bcInsnInvokeDynamicInsns);

    //     List<BcInsnJumpInsn> bcInsnJumpInsns = bcInsnJumpInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnJumpInsns().addAll(bcInsnJumpInsns);

    //     List<BcInsnLdcInsn> bcInsnLdcInsns = bcInsnLdcInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnLdcInsns().addAll(bcInsnLdcInsns);

    //     List<BcInsnLookupSwitchInsn> bcInsnLookupSwitchInsns = bcInsnLookupSwitchInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnLookupSwitchInsns().addAll(bcInsnLookupSwitchInsns);

    //     List<BcInsnMethodInsn> bcInsnMethodInsns = bcInsnMethodInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnMethodInsns().addAll(bcInsnMethodInsns);

    //     List<BcInsnMultiAnewArrayInsn> bcInsnMultiAnewArrayInsns = bcInsnMultiAnewArrayInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnMultiAnewArrayInsns().addAll(bcInsnMultiAnewArrayInsns);

    //     List<BcInsnTableSwitchInsn> bcInsnTableSwitchInsns = bcInsnTableSwitchInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnTableSwitchInsns().addAll(bcInsnTableSwitchInsns);

    //     List<BcInsnTypeInsn> bcInsnTypeInsns = bcInsnTypeInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnTypeInsns().addAll(bcInsnTypeInsns);

    //     List<BcInsnVarInsn> bcInsnVarInsns = bcInsnVarInsnService.query().eq("method_uuid", method_uuid).ge("insn_index", start_insn_index).le("insn_index", end_insn_index).list();
    //     allInsns.getBcInsnVarInsns().addAll(bcInsnVarInsns);


    //     return allInsns;
    // }
}
