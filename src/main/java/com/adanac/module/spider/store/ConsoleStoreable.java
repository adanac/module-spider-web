package com.adanac.module.spider.store;

import com.adanac.module.spider.domain.Page;

public class ConsoleStoreable implements Storeable {

	public void store(Page page) {
		System.out.println(page.getUrl() + "--" + page.getValues().get("price"));
	}

}
