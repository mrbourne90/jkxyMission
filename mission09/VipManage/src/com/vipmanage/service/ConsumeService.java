package com.vipmanage.service;

import org.springframework.data.domain.Page;

import com.vipmanage.model.Consume;

public interface ConsumeService {

	// 获取分页后的消费信息
	public Page<Consume> getConsumesWithPage(int page, int pageSize);

	// 获取指定vip的分页消费信息
	public Page<Consume> getConsumesByVipIdWithPage(int vipId, int page, int pageSize);

}
