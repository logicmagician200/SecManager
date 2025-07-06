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
@TableName("bc_field_info")
@ApiModel(value = "BcFieldInfo对象", description = "")
@Data
@Accessors(chain = true)
public class BcFieldInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目编号
     */
    @ApiModelProperty("项目编号")
    private Integer pId;

    /**
     * 用来关联 class_info 表
     */
    @ApiModelProperty("用来关联 class_info 表")
    private String classUuid;

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
     * 当前类的访问标识符，在 _class_visitor.visit 方法中获取
     */
    @ApiModelProperty("当前类的访问标识符，在 _class_visitor.visit 方法中获取")
    private String access;

    private String accessFlag;

    /**
     * 字段的值
     */
    @ApiModelProperty("字段的值")
    private String value;

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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getClassUuid() {
        return classUuid;
    }

    public void setClassUuid(String classUuid) {
        this.classUuid = classUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(String accessFlag) {
        this.accessFlag = accessFlag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumOfUpdate() {
        return numOfUpdate;
    }

    public void setNumOfUpdate(Integer numOfUpdate) {
        this.numOfUpdate = numOfUpdate;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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
        return "BcFieldInfo{" +
            "pId = " + pId +
            ", classUuid = " + classUuid +
            ", name = " + name +
            ", descriptor = " + descriptor +
            ", signature = " + signature +
            ", access = " + access +
            ", accessFlag = " + accessFlag +
            ", value = " + value +
            ", numOfUpdate = " + numOfUpdate +
            ", dataFlag = " + dataFlag +
            ", attribute = " + attribute +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
