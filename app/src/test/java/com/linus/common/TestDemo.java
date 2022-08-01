package com.linus.common;

import org.junit.Test;

/**
 * 描述：
 * 公司：深圳市旺龙智能科技有限公司
 *
 * @author HuQingHui
 * @date 2022/6/14
 */
public class TestDemo {
    @Test
    public void test01() {
        String updateInfo = null;
        if (updateInfo != null &true) {
            System.out.println("11111111111111111");
        } else {
            System.out.println("2222222222");
        }
    }

    @Test
    public void test02() {
        String s1 = "AAAA\r\n";
        String s2="AAAA";
        System.out.println("test02,s ->" + s1);
        System.out.println("s1 == s2->" + s1.trim().equals(s2));
    }
}
