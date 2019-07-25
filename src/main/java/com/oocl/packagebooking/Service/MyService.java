package com.oocl.packagebooking.Service;

import com.oocl.packagebooking.Entity.PackageOrder;
import com.oocl.packagebooking.Repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MyService {

       @Autowired
        private OrderRespository orderRespository;
       public MyService(){}
//        public void init(){
//        PackageOrder order1=new PackageOrder("1234","lisan","23456754y",3);
//        orderRespository.save(order1);
//        PackageOrder order2=new PackageOrder("1235","lisa","2463456754",3);
//        orderRespository.save(order2);
//        PackageOrder order3=new PackageOrder("123445624","zhangma","2345675467",5);
//        orderRespository.save(order3);
//    }

         public List<PackageOrder> getAll() {
             return orderRespository.findAll();
         }

         public PackageOrder findBuyNum(String number) {

             return orderRespository.findByNumber(number);

         }
         public PackageOrder increate(PackageOrder myPackage){
             PackageOrder aOrder = orderRespository.save(myPackage);
             return aOrder;

    }

        public void deletePackage(String number){
            PackageOrder order1 = orderRespository.findByNumber(number);
            orderRespository.delete(order1);
        }
        @Transactional
         public PackageOrder  updateOrder(String number,boolean status) {
            orderRespository.update(number, status);
            return orderRespository.findByNumber(number);
    }
}
