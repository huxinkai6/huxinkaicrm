package com.hxk.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("redis")
public class RedisTrans {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	/**
	 * ɾ��/�жϣ��޸Ĵ˴��ݲ�д����ʵ������ɾ�ٴ棩
	 */
	// ɾ��key�Ͷ�Ӧ��value
	public void delete(String key) {
		redisTemplate.delete(key);
	}


	// ɾ�����key�Ͷ�Ӧ��value
	public void delete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	// �ж��Ƿ�key
	public Boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	// String�洢
	public void setString(String key, String str) {
		redisTemplate.opsForValue().set(key, str);
	}
	// String�洢(����ʧЧ)
	public void setStringAndTimeOut(String key, String str, Integer expise) {
		redisTemplate.opsForValue().set(key, str);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// String��ȡ
	public String getString(String key) {
		Object key_value = redisTemplate.opsForValue().get(key);
		if (key_value != null) {
			String value = key_value.toString();
			return value;
		} else {
			return "";
		}
	}
	// List�洢
	public void setList(String key, List<Object> value2) {
		redisTemplate.opsForList().leftPush(key, value2);
	}

	// List�洢(����ʧЧ)
	public void setListAndTimeOut(String key, List<Object> value2, Integer expise) {
		redisTemplate.opsForList().leftPush(key, value2);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// List��ȡ
	@SuppressWarnings("unchecked")
	public List<Object> getList(String key) {
		return (List<Object>) redisTemplate.opsForList().leftPop(key);
	}

	// Map�洢
	public void setMap(String key, Map<Object, Object> value3) {
		redisTemplate.opsForHash().putAll(key, value3);
	}

	// Map�洢(����ʧЧ)
	public void setMapAndTimeOut(String key, Map<Object, Object> value3, Integer expise) {
		redisTemplate.opsForHash().putAll(key, value3);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// Map��ȡ
	public Map<Object, Object> getMap(String key) {
		return redisTemplate.opsForHash().entries(key);
	}


	// ȡ����key
	public Set<Object> getMapKeys(String key) {
		return redisTemplate.opsForHash().keys(key);
	}

	// ȡ����value
	public List<Object> getMapValues(String key) {
		return redisTemplate.opsForHash().values(key);
	}

	// ȡ��ӦMap��Ӧkeyֵ
	public Object getValueByMapKey(String map, String key) {
		return redisTemplate.opsForHash().get(map, key);
	}

	// Set�洢
	public void setSet(String key, Set<Object> set) {
		redisTemplate.opsForSet().add(key, set);
	}

	// Set�洢(����ʧЧ)
	public void setSetAndTimeOut(String key, Set<Object> set, Integer expise) {
		redisTemplate.opsForSet().add(key, set);
		redisTemplate.expire(key, expise, TimeUnit.SECONDS);
	}

	// Set��ȡ
	public Set<Object> getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}
}
