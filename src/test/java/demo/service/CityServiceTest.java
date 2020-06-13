package demo.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import demo.model.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {
	@Autowired
    private ICityService cityService;
	
	private ArrayList<String> nameList = new ArrayList<String>() { 
        { 
            add("Bratislava"); 
            add("Budapest"); 
            add("Prague");
            add("Warsaw"); 
            add("Los Angeles"); 
            add("New York");
            add("Edinburgh"); 
            add("Berlin"); 
            add("Taipei");
        } 
    }; 
    private ArrayList<Integer> populationList = new ArrayList<Integer>() { 
        { 
            add(432000); 
            add(1759000); 
            add(1280000);
            add(1748000); 
            add(3971000); 
            add(8550000);
            add(464000); 
            add(3671000); 
            add(23813606);
        } 
    };
    
	@Test
	public void testCityService() {
		List<City> cities = cityService.findAll();
		for(City element:cities ) {
			assertEquals(nameList.get(element.getId().intValue()-1),element.getName());
			assertEquals(populationList.get(Math.toIntExact(element.getId()-1)).intValue(),element.getPopulation());
		}
	}
    // @Test
	// public void testfailed() {
	// 	fail("Exception not thrown");
	// }
}
