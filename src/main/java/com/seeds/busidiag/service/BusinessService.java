package com.seeds.busidiag.service;

import com.seeds.busidiag.entity.Business;
import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;

import java.util.List;

public interface BusinessService {

    int save(Business business);


    int countByOwner(int ownerId);

    int countByOwnerAndStatus(int ownerId, BusinessStatus status);

    int countByOwnerAndType(int ownerId, BusinessType type);

    int countByOwnerAndStatusAndType(int ownerId, BusinessStatus status, BusinessType type);


    int updateById(Business business, int id);


    int deleteById(int id);


    List<Business> findAll();

    Business findById(int id);

    List<Business> findByOwner(int ownerId);
}
