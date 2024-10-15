package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.Family;

public interface FamilyRepo extends  JpaRepository<Family, Long>  {
	
	Family findByPrimaryMemberId(Long primaryMemberId);
    Family findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPrimaryMemberId(Long primaryMemberId);
}


