package com.example.board.mock;

import com.example.board.controller.BoardController;
import com.example.board.model.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class MockTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext ctx;


	@BeforeEach
	public void setUp(){
		//한글 설정
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
				.addFilters(new CharacterEncodingFilter("UTF-8", true))
				.alwaysDo(MockMvcResultHandlers.print())
				.build();
	}

	@Test
	public void getTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
											.get("/test")
											.param("key", "value"))
//			   .andExpect(MockMvcResultMatchers.status().isOk())
			   .andDo(MockMvcResultHandlers.print());
	}

}
