package kr.co.bnksys.board.presentation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class AppApiControllerTest {

	@Autowired
	MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	protected WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		// UTF-8 인코딩 설정
		this.mvc = MockMvcBuilders.webAppContextSetup(context)
				.addFilters(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}
	
	@Test
	void testLogin() {
		Map<String, String> params = new HashMap<>();
		params.put("userId", "qwerty");
		params.put("password", "aa12345^");
		
		try {
			System.out.println("json : " + objectMapper.writeValueAsString(params));
			
			MvcResult result = mvc.perform(post("/api/login")
					.content(objectMapper.writeValueAsString(params))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
			
			String responseJson = result.getResponse().getContentAsString();
			Map<String, Object> response = objectMapper.readValue(responseJson, new TypeReference<Map<String, Object>>() {
			});
			
			Map<String, Object> user = (Map<String, Object>) response.get("user");
			assertEquals("조영재(JO)", user.get("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("로그인 실패 테스트 NestedServletException을 반환함.")
	void testLoginFail() {
		Map<String, String> params = new HashMap<>();
		params.put("userId", "qwerty");
		params.put("password", "1234");
		
		assertThrows(NestedServletException.class, ()->{
			
			MvcResult result = mvc.perform(post("/api/login")
					.content(objectMapper.writeValueAsString(params))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andReturn();
		});
	}

}
