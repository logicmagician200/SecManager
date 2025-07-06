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
@TableName("log_scan_insn")
@ApiModel(value = "LogScanInsn对象", description = "")
@Data
public class LogScanInsn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer logScanId;

    /**
     * 操作码
     */
    @ApiModelProperty("操作码")
    private String opcode;

    /**
     * 第 2 个参数
     */
    @ApiModelProperty("第 2 个参数")
    private String str2;

    /**
     * 第 3 个参数
     */
    @ApiModelProperty("第 3 个参数")
    private String str3;

    /**
     * 第 4 个参数
     */
    @ApiModelProperty("第 4 个参数")
    private String str4;

    /**
     * 第 5 个参数
     */
    @ApiModelProperty("第 5 个参数")
    private String str5;

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

    public Integer getLogScanId() {
        return logScanId;
    }

    public void setLogScanId(Integer logScanId) {
        this.logScanId = logScanId;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4;
    }

    public String getStr5() {
        return str5;
    }

    public void setStr5(String str5) {
        this.str5 = str5;
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
        return "LogScanInsn{" +
            "id = " + id +
            ", logScanId = " + logScanId +
            ", opcode = " + opcode +
            ", str2 = " + str2 +
            ", str3 = " + str3 +
            ", str4 = " + str4 +
            ", str5 = " + str5 +
            ", insnIndex = " + insnIndex +
            ", sourceLine = " + sourceLine +
            ", dataFlag = " + dataFlag +
            ", remark = " + remark +
            ", updateTime = " + updateTime +
            ", createTime = " + createTime +
            "}";
    }
}
