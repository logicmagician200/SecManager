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
 * 注解的内容
 * </p>
 *
 * @author baomidou
 * @since 2025-07-06
 */
@TableName("bc_ann_content")
@ApiModel(value = "BcAnnContent对象", description = "注解的内容")
@Data
@Accessors(chain = true)
public class BcAnnContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ann_info 表中的 id
     */
    @ApiModelProperty("ann_info 表中的 id")
    private Integer annId;

    /**
     * 注解中变量的名称
     */
    @ApiModelProperty("注解中变量的名称")
    private String name;

    /**
     * 当注解的值是枚举时，用来描述枚举的类
     */
    @ApiModelProperty("当注解的值是枚举时，用来描述枚举的类")
    private String descriptor;

    /**
     * 注解的值
     */
    @ApiModelProperty("注解的值")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
        this.annId = annId;
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
        return "BcAnnContent{" +
            "id = " + id +
            ", annId = " + annId +
            ", name = " + name +
            ", descriptor = " + descriptor +
            ", value = " + value +
            ", numOfUpdate = " + numOfUpdate +
            ", dataFlag = " + dataFlag +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
