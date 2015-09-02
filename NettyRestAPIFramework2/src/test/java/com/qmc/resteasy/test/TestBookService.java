package com.qmc.resteasy.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qmc.resteasy.common.Constant;
import com.qmc.resteasy.model.Author;
import com.qmc.resteasy.test.httpclient.DefaultHttpClientHandle;


/**
 * @Description: 测试用例
 * @author xiaoli 
 * @date 2015-9-1 下午6:28:25 
 * 
 */
public class TestBookService {
	private static final Log logger = LogFactory
			.getLog(TestBookService.class);
	
	@Test
	public void testGetRestful() throws ClientProtocolException, IOException {
		String url = Constant.HOSTURL + "resteasy/ws/demo/book/2";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("keyCode", "guest");
		Object object = DefaultHttpClientHandle.httpGet(url, paramsMap);
		logger.info("testGetRestful object->"+object);
	}
	
	@Test
	public void testGetDetail() throws ClientProtocolException, IOException {
		String url = Constant.HOSTURL + "resteasy/ws/demo/book/detail";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("keyCode", "guest");
		paramsMap.put("id", 1);
		Object object = DefaultHttpClientHandle.httpGet(url, paramsMap);
		logger.info("testGetDetail object->"+object);
	}
	
	@Test
	public void testGetBookList() throws ClientProtocolException, IOException {
		String url = Constant.HOSTURL + "resteasy/ws/demo/book/list";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("keyCode", "guest");
		paramsMap.put("start", 0);
		paramsMap.put("limit", 10);
		Object object = DefaultHttpClientHandle.httpGet(url, paramsMap);
		logger.info("testGetDetail object->"+object);
	}
	
	@Test
	public void testSaveAuthor() throws ClientProtocolException, IOException {
		String url = Constant.HOSTURL + "resteasy/ws/demo/book/saveAuthor";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("keyCode", "guest");
		Map<String, String> formParam = new HashMap<String, String>();
		formParam.put("author",getTestJsonString());
		Object object = DefaultHttpClientHandle.httpPost(url, paramsMap, formParam);
		logger.info("testSaveAuthor object->"+object);
	}

	private String getTestJsonString() throws JsonGenerationException, JsonMappingException, IOException {
		Author author = new Author("shaozhipeng", "男", "程序员", 0, new Date(), new Date(), "zhipenglees@gmail.com", "zhipengs");
		return new ObjectMapper().writeValueAsString(author);
	}
	
}
