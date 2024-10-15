package com.web.familycontroller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.FamilyDTO;
import com.web.service.FamilyService;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("/create")
    public ResponseEntity<FamilyDTO> createFamily(@RequestBody FamilyDTO familyDTO) {
        FamilyDTO createdFamily = familyService.createFamily(familyDTO);
        return new ResponseEntity<>(createdFamily, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FamilyDTO>> getAllFamilies() {
        List<FamilyDTO> families = familyService.getAllFamilies();
        return new ResponseEntity<>(families, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDTO> getFamilyById(@PathVariable Long id) {
        FamilyDTO family = familyService.getFamilyById(id);
        return new ResponseEntity<>(family, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamily(@PathVariable Long id) {
        familyService.deleteFamily(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<FamilyDTO> getFamilyByPrimaryMemberOrPhone(
            @RequestParam(required = false) String primaryMemberName,
            @RequestParam(required = false) String phoneNumber) {
        FamilyDTO family = familyService.getFamilyByPrimaryMemberOrPhone(primaryMemberName, phoneNumber);
        return new ResponseEntity<>(family, HttpStatus.OK);
    }
}

