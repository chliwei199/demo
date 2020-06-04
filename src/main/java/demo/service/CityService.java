package demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import demo.model.City;



@Service
public class CityService implements ICityService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<City> findAll() {

        String sql = "SELECT * FROM cities";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class));
    }
}