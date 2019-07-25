package com.oocl.packagebooking;

import com.oocl.packagebooking.Entity.PackageOrder;
import com.oocl.packagebooking.Repository.OrderRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PackageBookingApplicationTests {
	@Autowired
	private OrderRespository orderRespository;

    @Before
    public void clearDb(){
        orderRespository.deleteAll();
    }

	@Test
	public void should_get_number_when_send_number() {
//		given
		PackageOrder myPackage=new PackageOrder("1233556","fangfang","134539567",4);
		orderRespository.save(myPackage);
		String name=orderRespository.findByName("fangfang").getName();
		String number=orderRespository.findByNumber("1233556").getNumber();
		Assertions.assertEquals("fangfang",name);
        Assertions.assertEquals("1233556",number);

	}
}
