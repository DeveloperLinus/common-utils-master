package com.linus.liu.showruzeltui;

/**
 * 描述：电梯模式
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author GentleWen
 * @date 2021/8/23
 */
public interface LiftMode {
    /**
     * 普通模式
     */
    int NORMAL_MODE = 0;
    /**
     * 上行高峰模式
     */
    int UP_BUSY_MODE = 1;
    /**
     * 即将进入高峰模式
     */
    int READY_BUSY_MODE = 11;
    /**
     * 即将退出高峰模式
     */
    int READY_EXIT_BUSY_MODE = 12;
}
