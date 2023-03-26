package com.ty.tymockdemo;

import com.ty.tymockdemo.mapper.TyMapper;
import com.ty.tymockdemo.service.impl.OderServiceImpl;
import com.ty.tymockdemo.service.impl.TyServiceImpl;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/3/26 10:37
 * @Version : 1.0.0
 **/

@RunWith(MockitoJUnitRunner.Silent.class)
public class TyServiceImplTest {

    @InjectMocks
    TyServiceImpl tyService = new TyServiceImpl();
    @Mock
    OderServiceImpl oderService ;
    @Mock
    TyMapper tyMapper;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFind() {

        List<String> tafRes = mock(List.class);
        List<String> res = mock(List.class);
        Mockito.when(oderService.findByOrderId("orderId")).thenReturn(tafRes);
        Mockito.when(tyMapper.find()).thenReturn(res);

        List<String> strings = tyService.find();

        Assume.assumeThat(res.size(), is(strings.size()));
    }


}
