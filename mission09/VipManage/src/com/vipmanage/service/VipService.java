package com.vipmanage.service;

import org.springframework.data.domain.Page;

import com.vipmanage.model.Vip;

public interface VipService {

	// 获取分页后的vip数据
	public Page<Vip> getVipsWithPage(int page, int pageSize);

	// 添加一个vip
	public Vip add(Vip vip);

	// 查找指定id的vip
	public Vip findOne(int id);
}
