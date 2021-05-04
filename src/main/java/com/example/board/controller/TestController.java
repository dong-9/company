package com.example.board.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@GetMapping(value="/a")
	public String test(){
		JSONObject obj = new JSONObject();

		JSONObject reqObj = new JSONObject();
		reqObj.put("time", "2021-05-04");
		reqObj.put("method", "test1 method");

		JSONArray requestAr = new JSONArray();
		requestAr.add(reqObj);

		JSONObject resObj = new JSONObject();
		resObj.put("time", "2021-05-04");
		resObj.put("method", "test2 method");

		JSONArray resAr = new JSONArray();
		resAr.add(resObj);

		obj.put("REQUEST", requestAr);
		obj.put("RESPONSE", resAr);
		String json = obj.toString();
		return json;
	}
}
