package org.devops.service;

import org.devops.dto.DecFaultRecordRequest;
import org.devops.dto.DecFaultRecordVO;
import org.devops.dto.base.PageDto;

/**
 * 设备故障记录服务
 */
public interface DecFaultRecordService {

    /**
     * 搜索
     * @param request 设备故障记录搜索请求
     * @return 分页返回数据
     */
    PageDto<DecFaultRecordVO> search(DecFaultRecordRequest request);
}
