package com.adanac.module.spider.reposity;

import com.adanac.module.spider.utils.RedisUtils;

public class RedisRepository implements Repository {
	RedisUtils redisUtils = new RedisUtils();

	public String poll() {
		String url = redisUtils.poll(RedisUtils.HIGHKEY);
		if (url == null) {
			url = redisUtils.poll(RedisUtils.LOWKEY);
		}
		return url;
	}

	public void addHigh(String nextUrl) {
		redisUtils.add(redisUtils.HIGHKEY, nextUrl);
	}

	public void add(String nextUrl) {
		redisUtils.add(redisUtils.LOWKEY, nextUrl);
	}

}
