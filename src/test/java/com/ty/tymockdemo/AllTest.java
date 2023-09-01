package com.ty.tymockdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TyControllerTest.class,
        TyServiceImplTest.class})
public class AllTest {

    @Test
    public void test() {

    }

}
