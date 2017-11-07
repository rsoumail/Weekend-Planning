package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.domain.Place;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WeatherService {
    final String WEATHER_API_URL = "https://www.prevision-meteo.ch/services/json/";

    public void service(){
        CityService cityService = new CityService();
        List<Place> villes = cityService.getAllCities();
        RestTemplate restTemplate = new RestTemplate();
        for(Place ville:villes){

        }
    }
}
