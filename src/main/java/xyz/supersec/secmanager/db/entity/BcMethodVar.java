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
@TableName("bc_method_var")
@ApiModel(value = "BcMethodVar对象", description = "")
@Data
public class BcMethodVar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String methodUuid;

    private Integer varIndex;

    /**
     * 变量名称
     */
    @ApiModelProperty("变量名称")
    private String varName;

    private String descriptor;

    private String signature;

    private String startLabel;

    /**
     * start_label 对应的行
     */
    @ApiModelProperty("start_label 对应的行")
    private Integer startLine;

    private String endLabel;

    /**
     * end_label 对应的行
     */
    @ApiModelProperty("end_label 对应的行")
    private Integer endLine;

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

    public Integer getVarIndex() {
        return varIndex;
    }

    public void setVarIndex(Integer varIndex) {
        this.varIndex = varIndex;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
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

    public String getStartLabel() {
        return startLabel;
    }

    public void setStartLabel(String startLabel) {
        this.startLabel = startLabel;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    public String getEndLabel() {
        return endLabel;
    }

    public void setEndLabel(String endLabel) {
        this.endLabel = endLabel;
    }

    public Integer getEndLine() {
        return endLine;
    }

    public void setEndLine(Integer endLine) {
        this.endLine = endLine;
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
        return "BcMethodVar{" +
            "methodUuid = " + methodUuid +
            ", varIndex = " + varIndex +
            ", varName = " + varName +
            ", descriptor = " + descriptor +
            ", signature = " + signature +
            ", startLabel = " + startLabel +
            ", startLine = " + startLine +
            ", endLabel = " + endLabel +
            ", endLine = " + endLine +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
