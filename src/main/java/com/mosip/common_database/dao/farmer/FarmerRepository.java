package com.mosip.common_database.dao.farmer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mosip.common_database.entity.farmer.FarmerEntity;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerEntity, Long>{

}
