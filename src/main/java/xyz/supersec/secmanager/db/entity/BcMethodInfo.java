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
@TableName("bc_method_info")
@ApiModel(value = "BcMethodInfo对象", description = "")
@Data
@Accessors(chain = true)
public class BcMethodInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pId;

    /**
     * 用来关联 class_info 表
     */
    @ApiModelProperty("用来关联 class_info 表")
    private String classUuid;

    private String uuid;

    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String name;

    /**
     * 字段描述符
     */
    @ApiModelProperty("字段描述符")
    private String descriptor;

    /**
     * 字段泛型签名
     */
    @ApiModelProperty("字段泛型签名")
    private String signature;

    /**
     * 字段访问标识
     */
    @ApiModelProperty("字段访问标识")
    private Integer access;

    private String accessFlag;

    /**
     * 字段的值
     */
    @ApiModelProperty("字段的值")
    private String exceptions;

    private Integer maxStack;

    private Integer maxLocals;

    /**
     * 更新次数
     */
    @ApiModelProperty("更新次数")
    private Integer numOfUpdate;

    /**
     * 标志位,ok 表示正常数据，deleted 表示已经删除，
     */
    @ApiModelProperty("标志位,ok 表示正常数据，deleted 表示已经删除，")
    private String dataFlag;

    private Integer maxInsnIndex;

    private String attribute;

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