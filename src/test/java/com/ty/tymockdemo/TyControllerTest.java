package com.ty.tymockdemo;

import com.ty.tymockdemo.controller.TyController;
import com.ty.tymockdemo.service.impl.TyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.mock;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TyControllerTest {

    @InjectMocks
    TyController tyController = new TyController();

    @Mock
    TyServiceImpl tyService;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testTest() {
        List<String> res = mock(List.class);
        res.add("1");
        // = mock(TyServiceImpl.class);

        Mockito.when(tyService.find()).thenReturn(res);
        List<String> test = tyController.test();
        Assert.assertEquals(res.size(), test.size());
        Mockito.doNothing().when(tyService).save("rpaTaskId");
    }

}
