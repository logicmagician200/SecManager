package xyz.supersec.secmanager.db.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("bc_inner_class_info")
@ApiModel(value = "BcInnerClassInfo对象", description = "")
@Data
public class BcInnerClassInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用来关联 class_info 表
     */
    @ApiModelProperty("用来关联 class_info 表")
    private String classUuid;

    /**
     * 当 _class_file 是外部类时可能会多次调用此方法（示例值：test/_nest_host_test$_c）。当 _class_file 是内部类时，inner_class_name 字段的内容和 class_name 字段的内容是一样的。可以在 _class_visitor.visit_nest_host 方法中获取 visit_inner_class
     */
    @ApiModelProperty("当 _class_file 是外部类时可能会多次调用此方法（示例值：test/_nest_host_test$_c）。当 _class_file 是内部类时，inner_class_name 字段的内容和 class_name 字段的内容是一样的。可以在 _class_visitor.visit_nest_host 方法中获取 visit_inner_class")
    private String innerClassName;

    /**
     * 当 _class_file 是外部类时可能会多次调用此方法（示例值：test/_nest_host_test）。可以在 _class_visitor.visit_inner_class 方法中获取
     */
    @ApiModelProperty("当 _class_file 是外部类时可能会多次调用此方法（示例值：test/_nest_host_test）。可以在 _class_visitor.visit_inner_class 方法中获取")
    private String innerClassOuterName;

    /**
     * 当 _class_file 是外部类时可能会多次调用此方法（示例值：_c）。可以在 _class_visitor.visit_inner_class 方法中获取
     */
    @ApiModelProperty("当 _class_file 是外部类时可能会多次调用此方法（示例值：_c）。可以在 _class_visitor.visit_inner_class 方法中获取")
    private String innerClassInnerName;

    /**
     * 内部类的访问标识符。可以在 _class_visitor.visit_inner_class 方法中获取
     */
    @ApiModelProperty("内部类的访问标识符。可以在 _class_visitor.visit_inner_class 方法中获取")
    private Integer innerClassAccess;

    private String innerClassAccessFlag;

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

    public String getClassUuid() {
        return classUuid;
    }

    public void setClassUuid(String classUuid) {
        this.classUuid = classUuid;
    }

    public String getInnerClassName() {
        return innerClassName;
    }

    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }

    public String getInnerClassOuterName() {
        return innerClassOuterName;
    }

    public void setInnerClassOuterName(String innerClassOuterName) {
        this.innerClassOuterName = innerClassOuterName;
    }

    public String getInnerClassInnerName() {
        return innerClassInnerName;
    }

    public void setInnerClassInnerName(String innerClassInnerName) {
        this.innerClassInnerName = innerClassInnerName;
    }

    public Integer getInnerClassAccess() {
        return innerClassAccess;
    }

    public void setInnerClassAccess(Integer innerClassAccess) {
        this.innerClassAccess = innerClassAccess;
    }

    public String getInnerClassAccessFlag() {
        return innerClassAccessFlag;
    }

    public void setInnerClassAccessFlag(String innerClassAccessFlag) {
        this.innerClassAccessFlag = innerClassAccessFlag;
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
        return "BcInnerClassInfo{" +
            "classUuid = " + classUuid +
            ", innerClassName = " + innerClassName +
            ", innerClassOuterName = " + innerClassOuterName +
            ", innerClassInnerName = " + innerClassInnerName +
            ", innerClassAccess = " + innerClassAccess +
            ", innerClassAccessFlag = " + innerClassAccessFlag +
            ", dataFlag = " + dataFlag +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
