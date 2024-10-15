package com.web.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNameAndFamilyId(String name, Long familyId);
}
