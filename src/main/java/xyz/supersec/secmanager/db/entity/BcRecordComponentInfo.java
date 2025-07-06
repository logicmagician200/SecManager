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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getRecordComponentName() {
        return recordComponentName;
    }

    public void setRecordComponentName(String recordComponentName) {
        this.recordComponentName = recordComponentName;
    }

    public String getRecordComponentDescriptor() {
        return recordComponentDescriptor;
    }

    public void setRecordComponentDescriptor(String recordComponentDescriptor) {
        this.recordComponentDescriptor = recordComponentDescriptor;
    }

    public String getRecordComponentSignature() {
        return recordComponentSignature;
    }

    public void setRecordComponentSignature(String recordComponentSignature) {
        this.recordComponentSignature = recordComponentSignature;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "BcRecordComponentInfo{" +
            "index = " + index +
            ", recordComponentName = " + recordComponentName +
            ", recordComponentDescriptor = " + recordComponentDescriptor +
            ", recordComponentSignature = " + recordComponentSignature +
            ", dataFlag = " + dataFlag +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
