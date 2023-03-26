package com.ty.tymockdemo;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MvcMockitoTest {
    //mockito 会将 @Mock、@Spy 修饰的对象自动注入到 @InjectMocks 修饰的对象中
    //定义MockMvc对象
    protected MockMvc mockMvc;
//    @Mock
//    //要mock被测类中依赖的对象使用@Mock注解
//    private KeywordsService keywordsService;
//    @Spy
//    //被 spy 的对象，调用其方法时默认会走真实方法。
//    private KeywordsServiceImpl keywordsServiceImpl;
//    @InjectMocks
//    //被测类本身使用@InjectMocks注解
//    private KeywordController controller;

//    @BeforeEach()
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        //初始化MockMvc对象,将KeywordController加载进Spring容器
//        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }
//    @Test
//    @DisplayName("findKeywordByIdTest")
//    public void findKeywordByIdTest() throws Exception {
//        Keywords keywords = new Builder ().setId(666).setKeyword("tester").setNotes("notes").build();
//        //打桩,当执行findKeywordById(1)时，就返回上面创建的keywords对象
//        Mockito.when(keywordsService.findKeywordById(1)).thenReturn(keywords);
//        //执行一个RequestBuider请求,自动执行SpringMvc的流程并映射到相应的控制器执行处理
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/keywords?id=1")    //请求的url,请求的方法是Get
//                        .contentType(MediaType.APPLICATION_JSON))  //数据的格式
//
//                //添加ResultMatcher验证规则,验证perform执行完成后的结果是否正确(对返回的数据进行判断)
//                .andExpect(status().isOk())   //期待的返回状态是200
//
//                //添加ResultHandler结果处理器,比如调试打印结果到控制台print()
//                .andDo(print())//打印出请求和相应的内容
//
//                //最后返回相应的MvcResult,然后进行自定义验证/进行下一步的异步处理
//                .andReturn();
//        System.out.println(mvcResult.getResponse().getContentAsString());
//    }


//    @Test
//    @DisplayName("addOne")
//    public void testAddOne() throws Exception {
//        Keywords build = new Builder().setId(1).setKeyword("addOne").setNotes("testAddOne").build();
//        Gson gson = new Gson();
//        String jsonString =gson.toJson(build);
//        System.out.println(jsonString);
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders.post("/api/add")
//                        .contentType(MediaType.APPLICATION_JSON)//发送的文本格式
//                        .content(jsonString)
//                        .accept(MediaType.APPLICATION_JSON)//接受的文本格式
//        )
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print()).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(status,200);
//        System.out.println("输出 " + mvcResult.getResponse().getContentAsString());
//    }
}
