package com.adanac.module.spider.reposity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.adanac.module.spider.utils.DomainUtils;
import com.adanac.module.spider.utils.RedisUtils;

/**
 * 随机获取某一个电商网站的url
 * @author Hades
 *
 */
public class RandomRedisRepository implements Repository {
	RedisUtils redisUtils = new RedisUtils();
	Map<String, String> hashMap = new HashMap<String, String>();
	Random random = new Random();

	public String poll() {
		String[] keyArray = hashMap.keySet().toArray(new String[0]);
		int nextInt = random.nextInt(keyArray.length);
		String key = keyArray[nextInt];
		String value = hashMap.get(key);
		return redisUtils.poll(value);
	}

	public void addHigh(String nextUrl) {
		String topDomain = DomainUtils.getTopDomain(nextUrl);
		String value = hashMap.get(topDomain);
		if (value == null) {
			value = topDomain;
			hashMap.put(topDomain, value);
		}
		redisUtils.add(topDomain, nextUrl);
	}

	public void add(String nextUrl) {
		addHigh(nextUrl);
	}

}
