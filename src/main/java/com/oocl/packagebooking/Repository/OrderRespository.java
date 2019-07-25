package com.oocl.packagebooking.Repository;

import com.oocl.packagebooking.Entity.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRespository extends JpaRepository<PackageOrder, Long>, JpaSpecificationExecutor<String> {
    PackageOrder findByName(String number);
    PackageOrder findByNumber(String number);

    @Modifying(clearAutomatically = true)
    @Query(value="update package_order set status = :status where number = :id",nativeQuery = true)
    public void update(@Param(value = "id") String id, @Param(value = "status") boolean status);

}
