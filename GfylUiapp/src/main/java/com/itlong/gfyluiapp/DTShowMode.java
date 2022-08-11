package com.itlong.gfyluiapp;

public enum DTShowMode {
    /**
     * 前往指定的电梯
     */
    GOTO_DT(1),
    /**
     * 选择楼层
     */
    SELECT_FLOOR(2),

    /**
     * 呼梯成功
     */
    ELEVATOR_SUCCEED(3),
    /**
     * 认证成功
     */
    CERTIFICATION_SUCCEED(4),
    /**
     * 电梯繁忙
     */
    ELEVATOR_BUSY(5),
    /**
     * 选择电梯
     */
    SELECT_DT(6),
    /**
     * 登记成功 register
     */
    REGISTER_SUCCEED(7),
    /**
     * 认证失败
     */
    CERTIFICATION_FAIL(8),
    /**
     * 电梯异常
     */
    DT_ERROR(9),
    /**
     * 电梯正在维修
     */
    DT_MODIFY(10);

    DTShowMode(int i) {
    }
}
