package org.devops.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "dev_fault_record")
public class DevFaultRecordPO implements Serializable {
    /**
     * 说明：主键ID
     * 类型：bigint
     */
    @TableId(value = "object_id",type = IdType.AUTO)
    private Long objectId;

    /**
     * 说明：设备编号
     * 类型：varchar(100)
     */
    @TableField(value = "device_code")
    private String deviceCode;

    /**
     * 说明：故障编号
     * 类型：varchar(50)
     */
    @TableField(value = "fault_code")
    private String faultCode;

    /**
     * 说明：状态
     * 类型：varchar(32)
     */
    @TableField(value = "status")
    private String status;

    /**
     * 说明：创建者
     * 类型：varchar(64)
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 说明：创建时间
     * 类型：datetime
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 说明：更新者
     * 类型：varchar（32）
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 说明：更新时间
     * 类型：datetime
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 说明：备注
     * 类型：varchar(500)
     */
    @TableField(value = "remark")
    private String remark;
}
