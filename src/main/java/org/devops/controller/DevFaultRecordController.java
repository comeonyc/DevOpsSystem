package org.devops.controller;

import org.devops.dto.DecFaultRecordRequest;
import org.devops.dto.DecFaultRecordVO;
import org.devops.dto.base.PageDto;
import org.devops.dto.base.ResultDTO;
import org.devops.service.DecFaultRecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 设备故障记录 controller 层
 * 1、定义HTTP接口
 * 2、异常统一由AOP处理
 * 3、可以填充一些必要的鉴权逻辑
 */
@RestController
@RequestMapping("/api/devops/devfault")
public class DevFaultRecordController {
    @Resource
    private DecFaultRecordService decFaultRecordService;

    /**
     * 设备故障记录搜索
     */
    @PostMapping(value = "/search")
    public ResultDTO<PageDto<DecFaultRecordVO>> search(@RequestBody DecFaultRecordRequest decFaultRecordRequest) {
        return ResultDTO.success(decFaultRecordService.search(decFaultRecordRequest));
    }
}
