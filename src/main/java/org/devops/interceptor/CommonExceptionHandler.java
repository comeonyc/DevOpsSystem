package org.devops.interceptor;

import org.devops.dto.base.ResultCode;
import org.devops.dto.base.ResultDTO;
import org.devops.utils.LogUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 统一异常处理，减少代码重复
     *
     * @param request http请求
     * @param e       异常
     * @return 返回标准Result格式
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResultDTO handleException(HttpServletRequest request, Exception e) {
        LogUtils.logError(getClass(), String.format("request url is : %s", request.getRequestURI()), e);

        if (e instanceof IllegalArgumentException) {
            return ResultDTO.fail(ResultCode.BAD_REQUEST, e.getMessage());
        } else {
            return ResultDTO.fail(ResultCode.FAIL, "服务端异常:" + e.getMessage());
        }
    }
}
