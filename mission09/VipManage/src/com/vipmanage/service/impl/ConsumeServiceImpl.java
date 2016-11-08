package com.vipmanage.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vipmanage.model.Consume;
import com.vipmanage.repository.ConsumeRepository;
import com.vipmanage.service.ConsumeService;

@Service("consumeService")
public class ConsumeServiceImpl implements ConsumeService {

	@Resource
	private ConsumeRepository consumeRepository;

	@Override
	public Page<Consume> getConsumesWithPage(int page, int pageSize) {
		PageRequest pageRequest = new PageRequest(page, pageSize, Direction.DESC, "consumeId");
		return consumeRepository.findAll(pageRequest);
	}

	@Override
	public Page<Consume> getConsumesByVipIdWithPage(int vipId, int page, int pageSize) {
		PageRequest pageRequest = new PageRequest(page, pageSize, Direction.ASC, "consumeId");
		Page<Consume> pageResults = consumeRepository.findByVip_VipId(vipId, pageRequest);
		if (pageResults.getContent().size() > 0) {
			return pageResults;
		} else {
			return null;
		}
	}

	public ConsumeRepository getConsumeRepository() {
		return consumeRepository;
	}

	public void setConsumeRepository(ConsumeRepository consumeRepository) {
		this.consumeRepository = consumeRepository;
	}

}
