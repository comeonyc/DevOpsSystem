package org.devops.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.ArrayUtils;
import org.devops.dto.DecFaultRecordRequest;
import org.devops.dto.DecFaultRecordVO;
import org.devops.dto.base.PageDto;
import org.devops.mapper.DevFaultRecordMapper;
import org.devops.po.DevFaultRecordPO;
import org.devops.service.DecFaultRecordService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 设备故障管理服务
 */
@Service
public class DecFaultRecordServiceImpl extends ServiceImpl<DevFaultRecordMapper, DevFaultRecordPO> implements DecFaultRecordService {

    /**
     * 根据请求参数做适当的搜索、分页
     * 返回给前端的字段目前定义了VO，包含表里面的所有字段，后续也可以更改成通用的map形式，key由前端输入来决定
     *
     * @param request 设备故障记录搜索请求
     * @return 分页的搜索结果
     */
    @Override
    public PageDto<DecFaultRecordVO> search(DecFaultRecordRequest request) {
        Page<DevFaultRecordPO> page = Page.of(request.getPageNumber(), request.getPageSize());

        QueryWrapper<DevFaultRecordPO> wrapper = geneWrapper(request.getParams());

        Page<DevFaultRecordPO> devFaultRecordPOPage = getBaseMapper().selectPage(page, wrapper);

        PageDto<DecFaultRecordVO> result = new PageDto<>();
        result.setTotal((int) devFaultRecordPOPage.getTotal());
        result.setData(devFaultRecordPOPage.getRecords().stream().map(this::toVO).collect(Collectors.toList()));
        return result;
    }

    private DecFaultRecordVO toVO(DevFaultRecordPO devFaultRecordPO) {
        DecFaultRecordVO vo = new DecFaultRecordVO();
        vo.setObjectId(devFaultRecordPO.getObjectId());
        vo.setDeviceCode(devFaultRecordPO.getDeviceCode());
        vo.setFaultCode(devFaultRecordPO.getFaultCode());
        vo.setStatus(devFaultRecordPO.getStatus());
        vo.setCreateBy(devFaultRecordPO.getCreateBy());
        vo.setCreateTime(devFaultRecordPO.getCreateTime());
        vo.setUpdateBy(devFaultRecordPO.getUpdateBy());
        vo.setUpdateTime(devFaultRecordPO.getUpdateTime());
        vo.setRemark(devFaultRecordPO.getRemark());
        return vo;
    }

    private QueryWrapper<DevFaultRecordPO> geneWrapper(Map<String, Object> params) {
        QueryWrapper<DevFaultRecordPO> wrapper = new QueryWrapper<>();

        Set<String> containFields =
                Arrays.stream((DevFaultRecordPO.class).getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!containFields.contains(entry.getKey())) {
                continue; //or throw exception
            }

            if (entry.getValue().getClass().isArray() || entry.getValue() instanceof Collection) {
                wrapper = wrapper.in(entry.getKey(), entry.getValue());
            } else {
                wrapper = wrapper.like(entry.getKey(), entry.getValue());
            }
        }

        return wrapper;
    }
}
