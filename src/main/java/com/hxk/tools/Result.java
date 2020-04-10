package com.hxk.tools;

	import java.util.HashMap;
	import java.util.Map;

	public class Result {
		public String code;//0,1
		public String msg;
		public Integer count;
		public Object data;
		public static Map<String, Object> toClient(int code, String msg) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", code);
			map.put("msg", msg);
			return map;
		}
		public static Map<String, Object> toClient(String code,String msg,Integer count,Object data){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", code);
			map.put("msg", msg);
			map.put("count", count);
			map.put("data", data);
			return map;
		}	
	}

