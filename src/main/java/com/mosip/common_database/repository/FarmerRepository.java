package com.mosip.common_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mosip.common_database.entity.FarmerEntity;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerEntity, Long>{

}
