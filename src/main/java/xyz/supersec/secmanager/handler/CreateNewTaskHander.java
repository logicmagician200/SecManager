package xyz.supersec.secmanager.handler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.supersec.secmanager.constant.TaskType;
import xyz.supersec.secmanager.db.entity.SysTaskInfo;
import xyz.supersec.secmanager.db.mapper.SysTaskInfoMapper;

// 创建新任务处理器
@Service
public class CreateNewTaskHander {

    @Autowired
    private SysTaskInfoMapper sysTaskInfoMapper;

    public SysTaskInfo createAsmTask(int msId) {

        SysTaskInfo sysTaskInfo = new SysTaskInfo();
        sysTaskInfo.setOrgId(1).setServiceId(1).setTaskType(TaskType.AsmScan.toString())
        .setStatus("newCreate").setStatusDesc("新建任务")
                .setUpdateTime(LocalDateTime.now()).setCreateTime(LocalDateTime.now());

        sysTaskInfoMapper.insert(sysTaskInfo);
        
        return sysTaskInfo;
    }


    public void handleNewTask(String taskType, String taskDetails) {
        // 处理新任务的逻辑
        // 例如，保存任务到数据库，发送通知等
        System.out.println("Handling new task of type: " + taskType);
        System.out.println("Task details: " + taskDetails);
    }



}
