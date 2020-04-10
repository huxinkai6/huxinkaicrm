package com.hxk.tools;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
	public static Map<String, Object> getResultMap(){
		Map<String, Object>  resultMap = new HashMap<String, Object>();
		resultMap.put("message", "ÍøÂçÒì³£");
		resultMap.put("remark", "");
		resultMap.put("success", false);
		return resultMap;
	}
	

}
