package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.domain.Place;
import fr.istic.m2il.weekendplanning.domain.Departement;
import fr.istic.m2il.weekendplanning.domain.Region;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CityService {

    final String PLACE_API_URL = "https://geo.api.gouv.fr/"; //https://geo.api.gouv.fr/regions?fields=nom,code&format=json

    public CityService(){

    }


    public List<Place> getAllCities(){
        List<Place> cities = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Region[] regions  = restTemplate.getForObject(PLACE_API_URL + "regions?fields=nom,code&format=json", Region[].class);
            for(Region region:regions){
                Departement[] departements = restTemplate.getForObject(
                        PLACE_API_URL + "regions/" + region.getCode() + "/departements?fields=nom,code", Departement[].class);
                for(Departement departement:departements){
                    Place[] citie = restTemplate.getForObject(PLACE_API_URL + "departements/" + departement.getCode() + "/communes?fields=nom,code", Place[].class);
                    for(Place city:citie){
                        cities.add(city);
                    }
                }

            }

        return cities;
    }

}
