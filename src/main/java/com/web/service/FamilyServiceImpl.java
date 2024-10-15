package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.FamilyDTO;
import com.web.dto.MemberDTO;
import com.web.exceptionHandler.AppException;
import com.web.model.Family;
import com.web.model.Member;
import com.web.model.PrimaryMember;
import com.web.repo.FamilyRepo;
import com.web.repo.MemberRepository;
import com.web.repo.PrimaryMemberRepository;

import jakarta.transaction.Transactional;

@Service
public class FamilyServiceImpl implements FamilyService {
	
	private static final Logger logger = LoggerFactory.getLogger(FamilyServiceImpl.class);

	@Autowired
    private FamilyRepo familyRepository;

    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private PrimaryMemberRepository primaryMemberRepository;

    @Override
    @Transactional
    public FamilyDTO createFamily(FamilyDTO familyDTO) {
        if (familyRepository.existsByPhoneNumber(familyDTO.getPhoneNumber())) {
        	logger.info("already exists  number...");
            throw new AppException("Phone number already exists in another family.", 409); // Conflict
        }

//        if (familyRepository.existsByPrimaryMemberId(familyDTO.getPrimaryMemberId())) {
//            throw new AppException("Primary member already exists in another family.", 409); // Conflict
//        }

        Family family = new Family();
        family.setFamilyName(familyDTO.getFamilyName());
        family.setAddress(familyDTO.getAddress());
        family.setCity(familyDTO.getCity());
        family.setPhoneNumber(familyDTO.getPhoneNumber());

        List<Member> members = new ArrayList<>();
        
        PrimaryMember primaryMember = null;
          
        for (MemberDTO memberDTO : familyDTO.getMembers()) {
            if (memberRepository.existsByNameAndFamilyId(memberDTO.getName(), family.getId())) {
                throw new AppException("Member already exists in this family.", 409); // Conflict
            }
            Member member = new Member();
            member.setName(memberDTO.getName());
            member.setAge(memberDTO.getAge());
            member.setGender(memberDTO.getGender());
            member.setProfession(memberDTO.getProfession());
            member.setRelation(memberDTO.getRelation());	
            member.setFamily(family);
            
            // Check if this member is the primary member
            if (memberDTO.isPrimary()) {

                primaryMember = new PrimaryMember();
                primaryMember.setName(memberDTO.getName());
                primaryMember.setAge(memberDTO.getAge());
                primaryMember.setGender(memberDTO.getGender());
                primaryMember.setRelation(memberDTO.getRelation());
                primaryMember.setProfession(memberDTO.getProfession());
                
                
                
                primaryMemberRepository.save(primaryMember);
                member.setPrimary(true);
                family.setPrimaryMember(primaryMember);
            }else {
            	member.setPrimary(false);
            }
            
            
            
            members.add(member);
        }

        family.setMembers(members);
     
      
        
        
        //family.setPrimaryMemberId(familyDTO.getPrimaryMemberId());
        familyRepository.save(family);
        
        return mapToDTO(family);
    }

    @Override
    public List<FamilyDTO> getAllFamilies() {
        List<Family> families = familyRepository.findAll();
        List<FamilyDTO> familyDTOs = new ArrayList<>();
        for (Family family : families) {
            familyDTOs.add(mapToDTO(family));
        }
        return familyDTOs;
    }

    @Override
    public FamilyDTO getFamilyById(Long id) {
        Family family = familyRepository.findById(id)
                .orElseThrow(() -> new AppException("Family not found", 404)); // Not Found
        return mapToDTO(family);
    }

    @Override
    public void deleteFamily(Long id) {
        if (!familyRepository.existsById(id)) {
            throw new AppException("Family not found", 404); // Not Found
        }
        familyRepository.deleteById(id);
    }

    @Override
    public FamilyDTO getFamilyByPrimaryMemberOrPhone(String primaryMemberName, String phoneNumber) {
        Family family = familyRepository.findByPhoneNumber(phoneNumber);
        if (family == null) {
            throw new AppException("Family with phone number not found", 404); // Not Found
        }

        if (family.getPrimaryMemberId() == null) {
            throw new AppException("Primary member ID is missing", 404); // Not Found
        }

        return mapToDTO(family);
    }

    private FamilyDTO mapToDTO(Family family) {
        FamilyDTO familyDTO = new FamilyDTO();
        familyDTO.setFamilyName(family.getFamilyName());
        familyDTO.setAddress(family.getAddress());
        familyDTO.setCity(family.getCity());
        familyDTO.setPhoneNumber(family.getPhoneNumber());
        familyDTO.setPrimaryMember(family.getPrimaryMember());
        //familyDTO.setPrimaryMemberId(family.getPrimaryMemberId());
        List<MemberDTO> memberDTOs = new ArrayList<>();
        for (Member member : family.getMembers()) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setName(member.getName());
            memberDTO.setAge(member.getAge());
            memberDTO.setGender(member.getGender());
            memberDTO.setRelation(member.getRelation());
            memberDTO.setProfession(member.getProfession());
          
            memberDTOs.add(memberDTO);
        }
        familyDTO.setMembers(memberDTOs);
        return familyDTO;
    }
}
