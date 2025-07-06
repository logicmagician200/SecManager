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
@TableName("bc_insn_try_catch_info")
@ApiModel(value = "BcInsnTryCatchInfo对象", description = "")
@Data
@Accessors(chain = true)
public class BcInsnTryCatchInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String methodUuid;

    /**
     * 开始的 label
     */
    @ApiModelProperty("开始的 label")
    private String startLabel;

    /**
     * 结束的 label
     */
    @ApiModelProperty("结束的 label")
    private String endLabel;

    /**
     * 捕获异常时，进行异常处理的 label
     */
    @ApiModelProperty("捕获异常时，进行异常处理的 label")
    private String handlerLabel;

    /**
     * 捕获的异常类型
     */
    @ApiModelProperty("捕获的异常类型")
    private String type;

    /**
     * 标志位,ok 表示正常数据，deleted 表示已经删除，
     */
    @ApiModelProperty("标志位,ok 表示正常数据，deleted 表示已经删除，")
    private String dataFlag;

    /**
     * 备注字段
     */
    @ApiModelProperty("备注字段")
    private String remark;

    /**
     * 最近更新时间
     */
    @ApiModelProperty("最近更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}