package xyz.supersec.secmanager.db.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("bc_insn_method_frame")
@ApiModel(value = "BcInsnMethodFrame对象", description = "")
@Data
@Accessors(chain = true)
public class BcInsnMethodFrame implements Serializable {

    private static final long serialVersionUID = 1L;

    private String methodUuid;

    /**
     * ASM 计算出的 label 的值
     */
    @ApiModelProperty("ASM 计算出的 label 的值")
    private String label;

    /**
     * 当前内容对应的源代码位置
     */
    @ApiModelProperty("当前内容对应的源代码位置")
    private Integer sourceLine;

    private Integer type;

    private Integer numLocal;

    private String local;

    private Integer numStack;

    private String stack;

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