package org.devops.dto.base;

import lombok.Data;

@Data
public class ResultDTO<T> {
    /**
     * 状态码
     */
    private int code;

    /**
     * 响应说明
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 返回成功
     *
     * @param data 数据
     * @return 成功的结果
     */
    public static <T> ResultDTO<T> success(T data) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败
     *
     * @param message 错误信息
     * @return 错误的结果
     */
    public static <T> ResultDTO<T> fail(ResultCode code, String message) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setCode(code.getCode());
        result.setMsg(message);
        return result;
    }
}
