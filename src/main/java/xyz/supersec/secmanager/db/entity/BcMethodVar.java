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
@TableName("bc_method_var")
@ApiModel(value = "BcMethodVar对象", description = "")
@Data
@Accessors(chain = true)
public class BcMethodVar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String methodUuid;

    private Integer varIndex;

    /**
     * 变量名称
     */
    @ApiModelProperty("变量名称")
    private String varName;

    private String descriptor;

    private String signature;

    private String startLabel;

    /**
     * start_label 对应的行
     */
    @ApiModelProperty("start_label 对应的行")
    private Integer startLine;

    private String endLabel;

    /**
     * end_label 对应的行
     */
    @ApiModelProperty("end_label 对应的行")
    private Integer endLine;

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