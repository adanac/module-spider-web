package com.adanac.module.spider.download;

import com.adanac.module.spider.domain.Page;

public interface Downloadable {
	public Page download(String url);
}
