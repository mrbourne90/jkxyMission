package com.vipmanage.service.impl;

import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.vipmanage.model.Vip;
import com.vipmanage.repository.VipRepository;
import com.vipmanage.service.VipService;

@Service("vipService")
public class VipServiceImpl implements VipService {

	@Resource
	private VipRepository vipRepository;

	@Override
	public Page<Vip> getVipsWithPage(int page, int pageSize) {

		PageRequest pageRequest = new PageRequest(page, pageSize, Direction.DESC, "vipId");
		return vipRepository.findAll(pageRequest);
	}

	@Override
	public Vip add(Vip vip) {
		return vipRepository.save(vip);
	}

	@Override
	public Vip findOne(int id) {
		return vipRepository.findOne(id);
	}

	public VipRepository getVipRepository() {
		return vipRepository;
	}

	public void setVipRepository(VipRepository vipRepository) {
		this.vipRepository = vipRepository;
	}
}
