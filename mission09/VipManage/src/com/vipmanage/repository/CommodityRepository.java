package com.vipmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipmanage.model.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {

}
