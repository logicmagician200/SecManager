package xyz.supersec.secmanager.db.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@TableName("bc_ann_info")
@ApiModel(value = "BcAnnInfo对象", description = "")
@Data
public class BcAnnInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    @ApiModelProperty("项目id")
    private Integer pId;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 注解的类型，需要和 target_uuid 搭配使用
     */
    @ApiModelProperty("注解的类型，需要和 target_uuid 搭配使用")
    private String targetType;

    /**
     * 使用注解的uuid，需要和 target_type 搭配使用
     */
    @ApiModelProperty("使用注解的uuid，需要和 target_type 搭配使用")
    private String targetUuid;

    private Integer typeRef;

    private String typePath;

    private String descriptor;

    private String visible;

    private String name;

    private Integer paramIndex;

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