package org.devops.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecFaultRecordVO {
    /**
     * 说明：主键ID
     */
    private Long objectId;

    /**
     * 说明：设备编号
     */
    private String deviceCode;

    /**
     * 说明：故障编号
     */
    private String faultCode;

    /**
     * 说明：状态
     */
    private String status;

    /**
     * 说明：创建者
     */
    private String createBy;

    /**
     * 说明：创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CMT+8")
    private Date createTime;

    /**
     * 说明：更新者
     */
    private String updateBy;

    /**
     * 说明：更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CMT+8")
    private Date updateTime;

    /**
     * 说明：备注
     */
    private String remark;
}
