package com.hxk.tools;

import java.util.HashMap;
import java.util.Map;



public class LayUiTableData {
	public int code;
	public String msg;
	public int count;
	public Object data;

	public static Map<String, Object> toClient(int status, String message, int total, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status);
		map.put("msg", message);
		map.put("count", total);
		map.put("data", data);
		return map;
	}

	public static Map<String, Object> toClient(int status, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status);
		map.put("msg", message);
		return map;
	}
	
	public static Map<String, Object> toClient1(String status, String message, int total, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status);
		map.put("msg", "");
		map.put("count", total);
		map.put("data", data);

		return map;
	}

	public static Map<String, Object> toClient1(String status, String message,String UserId,String loginUsername) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status);
		map.put("msg", message);
		map.put("UserId", UserId);
		map.put("loginUsername", loginUsername);
		return map;
	}
	
	
	public static boolean isNull(String str) {
		if (str == null || str.equals("") || str.equals("null")) {
			return true;
		} else {
			return false;
		}
	}
}
