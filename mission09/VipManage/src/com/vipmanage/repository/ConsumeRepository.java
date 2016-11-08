package com.vipmanage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vipmanage.model.Consume;

public interface ConsumeRepository extends JpaRepository<Consume, Integer> {

	// 根据vipId查找对应vip的消费信息
	public Page<Consume> findByVip_VipId(int vipid, Pageable pageable);
}
