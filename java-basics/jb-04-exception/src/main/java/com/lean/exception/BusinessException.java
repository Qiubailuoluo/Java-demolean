package com.lean.exception;

/**
 * 自定义<strong>非检查型</strong>异常（继承 RuntimeException）。
 * <p>业务层用其表达「可预期的失败」，无需在方法签名写 throws。</p>
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
