package org.devops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.devops.po.DevFaultRecordPO;

/**
 * 设备故障记录表数层Mapper
 */
@Mapper
public interface DevFaultRecordMapper extends BaseMapper<DevFaultRecordPO> {
}
