package xyz.supersec.secmanager.tools.asm.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.slf4j.Slf4j;
import xyz.supersec.secmanager.db.entity.BcAlertInfo;
import xyz.supersec.secmanager.db.entity.BcClassInfo;
import xyz.supersec.secmanager.db.entity.BcInnerClassInfo;
import xyz.supersec.secmanager.db.entity.BcRecordComponentInfo;
import xyz.supersec.secmanager.db.service.IBcAlertInfoService;
import xyz.supersec.secmanager.db.service.IBcAnnInfoService;
import xyz.supersec.secmanager.db.service.IBcClassInfoService;
import xyz.supersec.secmanager.db.service.IBcFieldInfoService;
import xyz.supersec.secmanager.db.service.IBcInnerClassInfoService;
import xyz.supersec.secmanager.db.service.IBcMethodInfoService;
import xyz.supersec.secmanager.db.service.IBcRecordComponentInfoService;
import xyz.supersec.secmanager.tools.asm.pojo.EbAnnInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbClassInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbFieldInfo;
import xyz.supersec.secmanager.tools.asm.pojo.EbMethodInfo;

@Slf4j
@Service
public class SaveEbInfo {
    @Autowired
    private IBcClassInfoService bcClassInfoService;
    @Autowired
    private IBcMethodInfoService bcMethodInfoService;
    @Autowired
    private IBcFieldInfoService bcFieldInfoService;
    @Autowired
    private IBcInnerClassInfoService bcInnerClassInfoService;
    @Autowired
    private IBcRecordComponentInfoService bcRecordComponentInfoService;
    @Autowired
    private IBcAnnInfoService bcAnnInfoService;
    @Autowired
    private IBcAlertInfoService bcAlertInfoService;


//    @Async("saveClassPool")
    @Transactional
    public void saveEbClass(EbClassInfo ebClassInfo) {
        BcClassInfo bcClassInfo = ebClassInfo.getDbPojo();
        bcClassInfoService.save(bcClassInfo);

        List<EbMethodInfo> ebMethodInfos = ebClassInfo.getEbMethodInfos();
        bcMethodInfoService.saveEb(ebMethodInfos);

        List<EbFieldInfo> ebFieldInfos = ebClassInfo.getEbFieldInfos();
        bcFieldInfoService.saveEb(ebFieldInfos);

        List<BcInnerClassInfo> innerClassInfos = ebClassInfo.getInnerClassInfos();
        bcInnerClassInfoService.saveBatch(innerClassInfos);

        List<BcRecordComponentInfo> recordComponentInfos = ebClassInfo.getRecordComponentInfos();
        bcRecordComponentInfoService.saveBatch(recordComponentInfos);

        List<EbAnnInfo> ebAnnInfos = ebClassInfo.getEbAnnInfos();
        bcAnnInfoService.saveEb(ebAnnInfos);

        List<BcAlertInfo> alertInfos = ebClassInfo.getAlertInfos();
        bcAlertInfoService.saveBatch(alertInfos);

    }




}
