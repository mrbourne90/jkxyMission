package com.vipmanage.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.vipmanage.model.Commodity;
import com.vipmanage.repository.CommodityRepository;
import com.vipmanage.service.CommodityService;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;

	@Override
	public Commodity add(Commodity commodity) {
		commodity.setAgio(new BigDecimal(commodity.getAgio().floatValue() / 100.0));
		return commodityRepository.save(commodity);
	}

	@Override
	public Commodity findOne(int id) {
		return commodityRepository.findOne(id);
	}

	@Override
	public Page<Commodity> getCommoditiesWithPage(int pageNo, int pageSize) {
		Sort sort = new Sort(new Order(Direction.ASC, "commodityId"));
		return commodityRepository.findAll(new PageRequest(pageNo, pageSize, sort));
	}

	public CommodityRepository getCommodityRepository() {
		return commodityRepository;
	}

	public void setCommodityRepository(CommodityRepository commodityRepository) {
		this.commodityRepository = commodityRepository;
	}

}
