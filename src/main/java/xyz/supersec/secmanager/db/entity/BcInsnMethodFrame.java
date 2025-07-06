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
@TableName("bc_insn_method_frame")
@ApiModel(value = "BcInsnMethodFrame对象", description = "")
@Data
@Accessors(chain = true)
public class BcInsnMethodFrame implements Serializable {

    private static final long serialVersionUID = 1L;

    private String methodUuid;

    /**
     * ASM 计算出的 label 的值
     */
    @ApiModelProperty("ASM 计算出的 label 的值")
    private String label;

    /**
     * 当前内容对应的源代码位置
     */
    @ApiModelProperty("当前内容对应的源代码位置")
    private Integer sourceLine;

    private Integer type;

    private Integer numLocal;

    private String local;

    private Integer numStack;

    private String stack;

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

    public String getMethodUuid() {
        return methodUuid;
    }

    public void setMethodUuid(String methodUuid) {
        this.methodUuid = methodUuid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumLocal() {
        return numLocal;
    }

    public void setNumLocal(Integer numLocal) {
        this.numLocal = numLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getNumStack() {
        return numStack;
    }

    public void setNumStack(Integer numStack) {
        this.numStack = numStack;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
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
        return "BcInsnMethodFrame{" +
            "methodUuid = " + methodUuid +
            ", label = " + label +
            ", sourceLine = " + sourceLine +
            ", type = " + type +
            ", numLocal = " + numLocal +
            ", local = " + local +
            ", numStack = " + numStack +
            ", stack = " + stack +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
