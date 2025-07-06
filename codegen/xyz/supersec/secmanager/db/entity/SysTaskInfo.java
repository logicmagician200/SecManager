package xyz.supersec.secmanager.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@TableName("sys_task_info")
@ApiModel(value = "SysTaskInfo对象", description = "")
public class SysTaskInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 组织ID
     */
    @ApiModelProperty("组织ID")
    private Integer orgId;

    /**
     * 服务ID
     */
    @ApiModelProperty("服务ID")
    private Integer serviceId;

    /**
     * 任务类型
     */
    @ApiModelProperty("任务类型")
    private String taskType;

    /**
     * 任务状态
     */
    @ApiModelProperty("任务状态")
    private String status;

    /**
     * 任务状态描述
     */
    @ApiModelProperty("任务状态描述")
    private String statusDesc;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysTaskInfo{" +
            "id = " + id +
            ", orgId = " + orgId +
            ", serviceId = " + serviceId +
            ", taskType = " + taskType +
            ", status = " + status +
            ", statusDesc = " + statusDesc +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
