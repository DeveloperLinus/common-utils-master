package com.linus.commonlib.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/7/18
 */
public class DpUtil {
    public static float dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return dpValue * density + 0.5f;
    }

    public static float sp2px(Context context, float spVal) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }
}
