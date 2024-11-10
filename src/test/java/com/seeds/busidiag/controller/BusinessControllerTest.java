package com.seeds.busidiag.controller;

import com.seeds.busidiag.service.impl.BusinessServiceImpl;
import com.seeds.busidiag.entity.Business;
import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;
import com.seeds.busidiag.repository.BusinessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class BusinessServiceImplTest {

    @MockBean
    private BusinessRepository businessRepository;

    @Autowired
    private BusinessServiceImpl businessService;

    private Business testBusiness;

    @BeforeEach
    void setUp() {
        testBusiness = Business.builder()
                .id(1)
                .ownerId(100)
                .type(BusinessType.PUBLIC)
                .size("SMALL")
                .status(BusinessStatus.ACTIVE)
                .date(LocalDate.now())
                .build();
    }

    @Test
    void save_ShouldReturnId() {
        when(businessRepository.save(any(Business.class))).thenReturn(testBusiness);

        int savedId = businessService.save(testBusiness);

        assertEquals(1, savedId);
        verify(businessRepository).save(testBusiness);
    }

    @Test
    void findById_WhenExists_ShouldReturnBusiness() {
        when(businessRepository.findById(1)).thenReturn(Optional.of(testBusiness));

        Business found = businessService.findById(1);

        assertNotNull(found);
        assertEquals(testBusiness.getId(), found.getId());
    }

    @Test
    void findById_WhenNotExists_ShouldThrowException() {
        when(businessRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> businessService.findById(999));
    }

    @Test
    void updateById_WhenExists_ShouldReturnId() {
        when(businessRepository.existsById(1)).thenReturn(true);
        when(businessRepository.save(any(Business.class))).thenReturn(testBusiness);

        int updatedId = businessService.updateById(testBusiness, 1);

        assertEquals(1, updatedId);
        verify(businessRepository).save(testBusiness);
    }

    @Test
    void updateById_WhenNotExists_ShouldThrowException() {
        when(businessRepository.existsById(999)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> businessService.updateById(testBusiness, 999));
    }

    @Test
    void deleteById_WhenExists_ShouldReturnId() {
        when(businessRepository.existsById(1)).thenReturn(true);
        doNothing().when(businessRepository).deleteById(1);

        int deletedId = businessService.deleteById(1);

        assertEquals(1, deletedId);
        verify(businessRepository).deleteById(1);
    }

    @Test
    void deleteById_WhenNotExists_ShouldThrowException() {
        when(businessRepository.existsById(999)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> businessService.deleteById(999));
    }

    @Test
    void findByOwner_WhenExists_ShouldReturnList() {
        when(businessRepository.findByOwnerId(100)).thenReturn(Optional.of(testBusiness));

        var businesses = businessService.findByOwner(100);

        assertFalse(businesses.isEmpty());
        assertEquals(1, businesses.size());
        assertEquals(testBusiness, businesses.get(0));
    }

    @Test
    void findByOwner_WhenNotExists_ShouldReturnEmptyList() {
        when(businessRepository.findByOwnerId(999)).thenReturn(Optional.empty());

        var businesses = businessService.findByOwner(999);

        assertTrue(businesses.isEmpty());
    }

    @Test
    void countByOwner_ShouldReturnCount() {
        when(businessRepository.countByOwnerId(100)).thenReturn(5);

        int count = businessService.countByOwner(100);

        assertEquals(5, count);
    }

    @Test
    void countByOwnerAndStatus_ShouldReturnCount() {
        when(businessRepository.countByOwnerIdAndStatus(100, BusinessStatus.ACTIVE)).thenReturn(3);

        int count = businessService.countByOwnerAndStatus(100, BusinessStatus.ACTIVE);

        assertEquals(3, count);
    }

    @Test
    void countByOwnerAndType_ShouldReturnCount() {
        when(businessRepository.countByOwnerIdAndType(100, BusinessType.PUBLIC)).thenReturn(2);

        int count = businessService.countByOwnerAndType(100, BusinessType.PUBLIC);

        assertEquals(2, count);
    }

    @Test
    void countByOwnerAndStatusAndType_ShouldReturnCount() {
        when(businessRepository.countByOwnerIdAndStatusAndType(100, BusinessStatus.ACTIVE, BusinessType.PUBLIC))
                .thenReturn(1);

        int count = businessService.countByOwnerAndStatusAndType(100, BusinessStatus.ACTIVE, BusinessType.PUBLIC);

        assertEquals(1, count);
    }

    @Test
    void findAll_ShouldReturnAllBusinesses() {
        when(businessRepository.findAll()).thenReturn(Arrays.asList(testBusiness, testBusiness));

        var businesses = businessService.findAll();

        assertFalse(businesses.isEmpty());
        assertEquals(2, businesses.size());
    }

    @Test
    void findAll_WhenEmpty_ShouldReturnEmptyList() {
        when(businessRepository.findAll()).thenReturn(Collections.emptyList());

        var businesses = businessService.findAll();

        assertTrue(businesses.isEmpty());
    }
}