package com.adanac.module.spider.reposity;

public interface Repository {

	String poll();

	void addHigh(String nextUrl);

	void add(String nextUrl);

}
