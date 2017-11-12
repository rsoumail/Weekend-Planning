package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.Place;
import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.domain.Weather;
import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import fr.istic.m2il.weekendplanning.service.weather.FcstDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class WeatherService {
    final String WEATHER_API_URL = "https://www.prevision-meteo.ch/services/json/";

    private final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    public void service(){
        CityService cityService = new CityService();
        List<Place> villes = cityService.getAllCities();
        activityRepository.toString();
       // List<Activity> activities = activityRepository.findAll();
        RestTemplate restTemplate = new RestTemplate();

        Weather w  = restTemplate.getForObject(WEATHER_API_URL + "rennes", Weather.class);

        log.info("Weather : {}", w.getFcst_day_0().getDate_Short());

        /*for(Place ville:villes){
            //FcstDay[] fcstDays  = restTemplate.getForObject(WEATHER_API_URL + ville.getNom().toLowerCase(), FcstDay[].class);

            Weather w  = restTemplate.getForObject(WEATHER_API_URL + "rennes", Weather.class);

            log.info("Weather : {}", w);
           *//* for(Activity activity:activities){
               *//**//* List<User> users = userRepository.findAllByActivityAndPlace(ville.getNom(), activity.getName());
                log.info("Usersss : {}", users);*//**//*
            }*//*
        }*/
    }
}
