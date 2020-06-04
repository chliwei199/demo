package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import demo.model.City;
import demo.service.ICityService;
import java.util.HashMap;
import java.util.List;

@Controller
public class CitiesController {

    @Autowired
    private ICityService cityService;

    @GetMapping(value="/cities")
    public ModelAndView showCities(Model model) {
    	List<City> cities = cityService.findAll();
    	HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("cities", cities);
        return new ModelAndView("showcities", params);
    }
}