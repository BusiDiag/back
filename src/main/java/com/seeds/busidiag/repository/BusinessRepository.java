package com.seeds.busidiag.repository;

import com.seeds.busidiag.entity.Business;
import com.seeds.busidiag.enums.BusinessStatus;
import com.seeds.busidiag.enums.BusinessType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Integer> {

    Optional<Business> findByOwnerId(@NotNull int ownerId);

    int countByOwnerId(@NotNull int ownerId);

    int countByOwnerIdAndStatus(@NotNull int ownerId, @NotNull BusinessStatus status);

    int countByOwnerIdAndType(@NotNull int ownerId, @NotNull BusinessType type);

    int countByOwnerIdAndStatusAndType(@NotNull int ownerId, @NotNull BusinessStatus status, @NotNull BusinessType type);
}
