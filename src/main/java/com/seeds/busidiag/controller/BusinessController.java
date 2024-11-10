package com.seeds.busidiag.controller;

import com.seeds.busidiag.entity.Business;
import com.seeds.busidiag.service.BusinessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity<Integer> createBusiness(@Valid @RequestBody Business business) {
        int createdBusinessId = businessService.save(business);
        return new ResponseEntity<>(createdBusinessId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> findBusinessById(@PathVariable int id) {
        Optional<Business> business = Optional.ofNullable(businessService.findById(id));
        return business.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Business>> getAllBusinesses() {
        List<Business> businesses = businessService.findAll();
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Business>> getBusinessesByOwnerId(@PathVariable int ownerId) {
        List<Business> businesses = businessService.findByOwner(ownerId);
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateBusiness(
            @PathVariable int id,
            @Valid @RequestBody Business businessDetails
    ) {
        Optional<Business> existingBusiness = Optional.ofNullable(businessService.findById(id));
        if (existingBusiness.isPresent()) {
            businessDetails.setId(id);
            return new ResponseEntity<>(businessService.save(businessDetails), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable int id) {
        Optional<Business> existingBusiness = Optional.ofNullable(businessService.findById(id));
        if (existingBusiness.isPresent()) {
            businessService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}