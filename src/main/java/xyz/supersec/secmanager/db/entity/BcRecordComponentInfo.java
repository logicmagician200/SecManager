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
@TableName("bc_record_component_info")
@ApiModel(value = "BcRecordComponentInfo对象", description = "")
@Data
@Accessors(chain = true)
public class BcRecordComponentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用来管理 class_info 表
     */
    @ApiModelProperty("用来管理 class_info 表")
    private String index;

    /**
     * _java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取
     */
    @ApiModelProperty("_java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取")
    private String recordComponentName;

    /**
     * _java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取
     */
    @ApiModelProperty("_java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取")
    private String recordComponentDescriptor;

    /**
     * _java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取
     */
    @ApiModelProperty("_java 14引入了一个新的关键字record，用于解决模板代码问题，，可以通过 _class_visitor.visitRecord_component 方法获取")
    private String recordComponentSignature;

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