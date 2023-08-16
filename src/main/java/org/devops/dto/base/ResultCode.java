package org.devops.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果状态枚举
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    FAIL(500, "服务端异常"),
    BAD_REQUEST(400, "参数错误"),
    SUCCESS(0,"成功");

    private final int code;
    private final String msg;
}
