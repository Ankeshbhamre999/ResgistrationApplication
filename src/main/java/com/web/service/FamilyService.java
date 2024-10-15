package com.web.service;

import java.util.List;

import com.web.dto.FamilyDTO;


public interface FamilyService {
    FamilyDTO createFamily(FamilyDTO familyDTO);
    List<FamilyDTO> getAllFamilies();
    FamilyDTO getFamilyById(Long id);
    void deleteFamily(Long id);
    FamilyDTO getFamilyByPrimaryMemberOrPhone(String primaryMemberName, String phoneNumber);
}
