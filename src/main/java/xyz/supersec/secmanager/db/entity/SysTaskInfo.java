package xyz.supersec.secmanager.db.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Data
@Accessors(chain = true)
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
}