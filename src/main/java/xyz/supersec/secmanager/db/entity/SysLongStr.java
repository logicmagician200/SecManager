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
@TableName("sys_long_str")
@ApiModel(value = "SysLongStr对象", description = "")
@Data
@Accessors(chain = true)
public class SysLongStr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 备注的主标号
     */
    @ApiModelProperty("备注的主标号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 备注的子编号
     */
    @ApiModelProperty("备注的子编号")
    private Integer subId;

    /**
     * 具体的内容
     */
    @ApiModelProperty("具体的内容")
    private String content;

    /**
     * 标志位
     */
    @ApiModelProperty("标志位")
    private String dataFlag;

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