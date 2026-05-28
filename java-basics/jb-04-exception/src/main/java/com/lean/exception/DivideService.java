package com.lean.exception;

/**
 * 除法服务：演示用异常表达非法参数，而非返回魔法数字。
 */
public final class DivideService {

    private DivideService() {
    }

    /**
     * @throws BusinessException 除数为 0
     */
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new BusinessException("除数不能为 0");
        }
        return (double) a / b;
    }
}
