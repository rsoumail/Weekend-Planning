package fr.istic.m2il.weekendplanning.service;


import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.Place;

import fr.istic.m2il.weekendplanning.domain.Weather;
import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import fr.istic.m2il.weekendplanning.service.weather.FcstDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class WeatherService {


    @Autowired
    private CityService cityService;

    @Scheduled(cron = "0 25 12 * * 0-2")
    public void service() {
        cityService.execute();
    }
}

