package org.devops.service;

import org.devops.BaseTest;
import org.devops.dto.DecFaultRecordRequest;
import org.devops.dto.DecFaultRecordVO;
import org.devops.dto.base.PageDto;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.HashMap;

public class DevFaultRecordServiceTest extends BaseTest {

    @Resource
    private DecFaultRecordService decFaultRecordService;

    @Test
    public void search(){
        DecFaultRecordRequest request = new DecFaultRecordRequest();
        request.setPageNumber(1);
        request.setPageSize(10);
        request.setParams(new HashMap<>());

        PageDto<DecFaultRecordVO> search = decFaultRecordService.search(request);

        System.out.println("");
    }
}
