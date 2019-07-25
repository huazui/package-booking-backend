package com.oocl.packagebooking.Repository;

import com.oocl.packagebooking.Entity.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRespository extends JpaRepository<PackageOrder, Long>, JpaSpecificationExecutor<String> {
    PackageOrder findByName(String number);
    PackageOrder findByNumber(String number);
}
