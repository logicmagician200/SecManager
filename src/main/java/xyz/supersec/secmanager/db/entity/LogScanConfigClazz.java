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
@TableName("log_scan_config_clazz")
@ApiModel(value = "LogScanConfigClazz对象", description = "")
@Data
@Accessors(chain = true)
public class LogScanConfigClazz implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类名
     */
    @ApiModelProperty("类名")
    private String className;

    /**
     * 方法名
     */
    @ApiModelProperty("方法名")
    private String method;

    /**
     * 方法描述符
     */
    @ApiModelProperty("方法描述符")
    private String description;

    /**
     * 类所在 jar 包的版本
     */
    @ApiModelProperty("类所在 jar 包的版本")
    private String version;

    /**
     * 数据标识
     */
    @ApiModelProperty("数据标识")
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