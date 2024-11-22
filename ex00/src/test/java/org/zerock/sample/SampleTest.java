package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //단위테스트 설정
@Log4j //로그출력
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTest {
	
	@Autowired
	private Restaurant restaurant; // = new Restaurant;
	
	/*
	 * @Autowired private Chef chef;
	 * 
	 * @Autowired private SampleHotel sampleHotel;
	 */
	
	@Test
	public void testExist() {
		log.info("restaurant : " + restaurant);
		log.info(restaurant.getChef());
//		System.out.println("restaurant : " + restaurant);
//		System.out.println("restaurant : " + restaurant.getChef());
	}
	
	/*
	 @Test 
	 public void testHotel() { 
	 System.out.println("sampleHotel : " + SampleHotel);
	 System.out.println("sampleHotel : " + sampleHotel.getChef()); }
	*/
}
