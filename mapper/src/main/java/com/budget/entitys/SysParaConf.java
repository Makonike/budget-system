package com.budget.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 13:28
 *
 * 系统参数配置实体
 */
public class SysParaConf implements Serializable {

    private static final long serialVersionUID = -1855927439599925856L;

    //主键ID
    private Long id;

    //系统code
    private String sysCode;

    //系统val
    private String sysVal;

    //备注
    private String memo;

    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysVal() {
        return sysVal;
    }

    public void setSysVal(String sysVal) {
        this.sysVal = sysVal;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public SysParaConf() {
    }

    public SysParaConf(String sysCode, String sysVal, String memo) {
        this.sysCode = sysCode;
        this.sysVal = sysVal;
        this.memo = memo;
    }
}
