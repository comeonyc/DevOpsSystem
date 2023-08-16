package org.devops.controller;

import org.devops.BaseTest;
import org.devops.dto.DecFaultRecordRequest;
import org.devops.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class DevFaultRecordControllerTest extends BaseTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testSearch() throws Exception {
        DecFaultRecordRequest pageReqDto = new DecFaultRecordRequest();
        pageReqDto.setPageNumber(1);
        pageReqDto.setPageSize(20);
        pageReqDto.setParams(new HashMap<>());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/devops/devfault/search")
                        .contentType(MediaType.APPLICATION_JSON).content(JsonUtils.writeToString(pageReqDto))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result);
    }
}
