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
@TableName("bc_insn_invoke_dynamic_insn")
@ApiModel(value = "BcInsnInvokeDynamicInsn对象", description = "")
@Data
public class BcInsnInvokeDynamicInsn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String methodUuid;

    /**
     * 操作码
     */
    @ApiModelProperty("操作码")
    private String opcode;

    /**
     * 第 2 个参数
     */
    @ApiModelProperty("第 2 个参数")
    private String name;

    /**
     * 第 3 个参数
     */
    @ApiModelProperty("第 3 个参数")
    private String descriptor;

    /**
     * 第 4 个参数
     */
    @ApiModelProperty("第 4 个参数")
    private Integer handleTag;

    /**
     * 第 5 个参数
     */
    @ApiModelProperty("第 5 个参数")
    private String handleOwner;

    /**
     * 第 2 个参数
     */
    @ApiModelProperty("第 2 个参数")
    private String handleName;

    /**
     * 第 3 个参数
     */
    @ApiModelProperty("第 3 个参数")
    private String handleDescriptor;

    /**
     * 第 4 个参数
     */
    @ApiModelProperty("第 4 个参数")
    private String handleIsInterface;

    /**
     * 第 5 个参数
     */
    @ApiModelProperty("第 5 个参数")
    private String methodArgs;

    /**
     * 当作内容在方法中的指针
     */
    @ApiModelProperty("当作内容在方法中的指针")
    private Integer insnIndex;

    /**
     * 当前内容对应的源代码位置
     */
    @ApiModelProperty("当前内容对应的源代码位置")
    private Integer sourceLine;

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

    public String getMethodUuid() {
        return methodUuid;
    }

    public void setMethodUuid(String methodUuid) {
        this.methodUuid = methodUuid;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
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

    public Integer getHandleTag() {
        return handleTag;
    }

    public void setHandleTag(Integer handleTag) {
        this.handleTag = handleTag;
    }

    public String getHandleOwner() {
        return handleOwner;
    }

    public void setHandleOwner(String handleOwner) {
        this.handleOwner = handleOwner;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public String getHandleDescriptor() {
        return handleDescriptor;
    }

    public void setHandleDescriptor(String handleDescriptor) {
        this.handleDescriptor = handleDescriptor;
    }

    public String getHandleIsInterface() {
        return handleIsInterface;
    }

    public void setHandleIsInterface(String handleIsInterface) {
        this.handleIsInterface = handleIsInterface;
    }

    public String getMethodArgs() {
        return methodArgs;
    }

    public void setMethodArgs(String methodArgs) {
        this.methodArgs = methodArgs;
    }

    public Integer getInsnIndex() {
        return insnIndex;
    }

    public void setInsnIndex(Integer insnIndex) {
        this.insnIndex = insnIndex;
    }

    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
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
        return "BcInsnInvokeDynamicInsn{" +
            "id = " + id +
            ", methodUuid = " + methodUuid +
            ", opcode = " + opcode +
            ", name = " + name +
            ", descriptor = " + descriptor +
            ", handleTag = " + handleTag +
            ", handleOwner = " + handleOwner +
            ", handleName = " + handleName +
            ", handleDescriptor = " + handleDescriptor +
            ", handleIsInterface = " + handleIsInterface +
            ", methodArgs = " + methodArgs +
            ", insnIndex = " + insnIndex +
            ", sourceLine = " + sourceLine +
            ", dataFlag = " + dataFlag +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
