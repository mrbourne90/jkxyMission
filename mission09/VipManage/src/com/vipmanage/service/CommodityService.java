package com.vipmanage.service;

import org.springframework.data.domain.Page;

import com.vipmanage.model.Commodity;

public interface CommodityService {

	// 添加一条商品
	public Commodity add(Commodity commodity);

	// 返回分页后的商品数据
	public Page<Commodity> getCommoditiesWithPage(int pageNo, int pageSize);

	// 根据id查找一条商品
	public Commodity findOne(int id);
}
