package com.seeds.busidiag.service.impl;

import com.seeds.busidiag.entity.Business;
import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;
import com.seeds.busidiag.repository.BusinessRepository;
import com.seeds.busidiag.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public int save(Business business) {
        Business savedBusiness = businessRepository.save(business);
        return savedBusiness.getId();
    }

    @Override
    public Business findById(int id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }

    @Override
    public int updateById(Business business, int id) {
        if (!businessRepository.existsById(id)) {
            throw new RuntimeException("Business not found with id: " + id);
        }
        business.setId(id);
        businessRepository.save(business);
        return id;
    }

    @Override
    public int deleteById(int id) {
        if (!businessRepository.existsById(id)) {
            throw new RuntimeException("Business not found with id: " + id);
        }
        businessRepository.deleteById(id);
        return id;
    }

    @Override
    public Business findByOwner(int ownerId) {
        return businessRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new RuntimeException("No business found for owner: " + ownerId));
    }

    @Override
    public int countByOwner(int ownerId) {
        return businessRepository.countByOwnerId(ownerId);
    }

    @Override
    public int countByOwnerAndStatus(int ownerId, BusinessStatus status) {
        return businessRepository.countByOwnerIdAndStatus(ownerId, status);
    }

    @Override
    public int countByOwnerAndType(int ownerId, BusinessType type) {
        return businessRepository.countByOwnerIdAndType(ownerId, type);
    }

    @Override
    public int countByOwnerAndStatusAndType(int ownerId, BusinessStatus status, BusinessType type) {
        return businessRepository.countByOwnerIdAndStatusAndType(ownerId, status, type);
    }
}
