package com.yvan;

import com.google.gson.Gson;
import com.yvan.cache.RedisClient;
import com.yvan.platform.JsonWapper;
import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
/** 
 * 说明：参数封装Map
 * 创建人：FH Q313596790
 * 修改时间：2014年9月20日
 * @version
 */
public class PageData extends HashMap implements Map{
	
	private static final long serialVersionUID = 1L;
	
	Map map = null;
	HttpServletRequest request;
	public PageData(HttpServletRequest request){
		this.request = request;
		Map properties = getRequestPayload(request);
		if(properties.isEmpty()){
			properties = request.getParameterMap();
		}
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if(null == valueObj){
				value = "";
			}else if(valueObj instanceof String[]){
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){
					 value = values[i] + ",";
				}
				value = value.substring(0, value.length()-1);
			}else{
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		String  sessionID =  request.getHeader("sessionID");
		if(!StringUtils.isEmpty(sessionID)){
			String[] atrrs = sessionID.split(":");
			if(atrrs.length==4){
				String userId = atrrs[1];
				returnMap.put("cuser", userId);
				returnMap.put("uuser", userId);
				returnMap.put("currentUserId", userId);
				returnMap.put("sessionID",sessionID);
			}
		}

		map = returnMap;
	}




	public static Map getRequestPayload(HttpServletRequest req) {

		StringBuilder sb = new StringBuilder();

		try {

			BufferedReader reader = req.getReader();

			char[]buff = new char[1024];

			int len;

			while((len = reader.read(buff)) != -1) {


				sb.append(buff,0, len);

			}

		} catch (IOException e) {

			e.printStackTrace();

		}


//		Gson gson = new Gson();
//		Map map = gson.fromJson(sb.toString(), Map.class);
//		JsonWapper jsonWapper = new JsonWapper(sb.toString());
//		Map map = jsonWapper.asObject(Map.class);
		if(StringUtils.isEmpty(sb.toString())){
			return new HashMap();
		}
		Map map = YvanUtil.jsonToObj(sb.toString(), Map.class);
		return map==null?new HashMap():map;

	}

	
	public PageData() {
		map = new HashMap();
	}
	
	@Override
	public Object get(Object key) {
		Object obj = null;
		if(map.get(key) instanceof Object[]) {
			Object[] arr = (Object[])map.get(key);
			obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}
	
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		// TODO Auto-generated method stub
		map.putAll(t);
	}

	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
}
