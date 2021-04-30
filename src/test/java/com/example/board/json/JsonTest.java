package com.example.board.json;

import com.example.board.model.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonTest {

	@Test
	public void json() throws JsonProcessingException, ParseException {
		// TODO JSONParser, JSONObject, JSONMapper 알아보기
		Log log = new Log();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("test1", 1);
		jsonObject.put("test2", 2);
		jsonObject.put("test3", 3);
		System.out.println(jsonObject.toJSONString());
	}
}
