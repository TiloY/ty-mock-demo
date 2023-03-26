package com.ty.tymockdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/3/26 22:26
 * @Version : 1.0.0
 **/

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TyControllerTest.class,
        TyServiceImplTest.class})
public class AllTest {

    @Test
    public void test() {

    }

}
