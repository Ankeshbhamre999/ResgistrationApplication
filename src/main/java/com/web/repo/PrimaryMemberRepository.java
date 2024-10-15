package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.PrimaryMember;

@Repository
public interface PrimaryMemberRepository extends JpaRepository<PrimaryMember, Long> {
}
