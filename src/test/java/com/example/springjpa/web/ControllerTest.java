package com.example.springjpa.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTest {

    @Resource
    WebApplicationContext wac;

    MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void build(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
        session=new MockHttpSession();
        session.setAttribute("user","x");
    }

    @Test
    public void test01() throws Exception {
        String param="{\"param\":\"hello\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/mvcpost")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(param.getBytes("utf-8"))
                 )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());;
    }

    @Test
    public void test02() throws Exception {
        String param="{\"param\":\"hello\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/mvcget?param=133")

        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());;
    }
}
