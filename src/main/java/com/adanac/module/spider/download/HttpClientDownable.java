package com.adanac.module.spider.download;

import com.adanac.module.spider.domain.Page;
import com.adanac.module.spider.utils.PageUtils;

public class HttpClientDownable implements Downloadable {

	public Page download(String url) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setUrl(url);
		page.setContent(PageUtils.getContent(url));
		return page;
	}

}
