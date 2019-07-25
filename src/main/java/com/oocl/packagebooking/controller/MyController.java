package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.Entity.PackageOrder;
import com.oocl.packagebooking.Repository.OrderRespository;
import com.oocl.packagebooking.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class MyController {
@Autowired
  private MyService  myService;


    @GetMapping("/{id}")
    public ResponseEntity<PackageOrder>  getPackage(@PathVariable("id") String id){
        PackageOrder myPackage=myService.findBuyNum(id);
        return ResponseEntity.ok(myPackage);
    }

    @GetMapping
    public ResponseEntity<List<PackageOrder>> getAll(){

    List<PackageOrder> orders=myService.getAll();
    return ResponseEntity.ok(orders);
}

   @PutMapping("/{id}")
   public ResponseEntity<PackageOrder> updateStatus(@PathVariable("id") String id,@RequestParam("status")boolean status){

    PackageOrder myOrder=myService.updateOrder(id,status);
    return ResponseEntity.ok(myOrder);
}
  @PostMapping
   public ResponseEntity<PackageOrder> addOrder(@RequestBody PackageOrder aPacakge){
  PackageOrder  myP=myService.increate(aPacakge);
     return ResponseEntity.ok(myP);
}
  @DeleteMapping("/{id}")
public ResponseEntity deletePackage(@PathVariable("id")String id){
  myService.deletePackage(id);
return ResponseEntity.status(HttpStatus.CREATED).build();
}
}