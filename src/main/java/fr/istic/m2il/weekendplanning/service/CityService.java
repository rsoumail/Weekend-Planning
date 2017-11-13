package fr.istic.m2il.weekendplanning.service;

import fr.istic.m2il.weekendplanning.domain.*;
import fr.istic.m2il.weekendplanning.repository.ActivityRepository;
import fr.istic.m2il.weekendplanning.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MailService mailService;

    private final Logger log = LoggerFactory.getLogger(CityService.class);

    final String PLACE_API_URL = "https://geo.api.gouv.fr/"; //https://geo.api.gouv.fr/regions?fields=nom,code&format=json
    final String WEATHER_API_URL = "https://www.prevision-meteo.ch/services/json/";


    public void execute(){
        List<Place> cities = new ArrayList<>();
        List<Activity> activities = activityRepository.findAll();
        RestTemplate restTemplate = new RestTemplate();
        Region[] regions  = restTemplate.getForObject(PLACE_API_URL + "regions?fields=nom,code&format=json", Region[].class);
        for(Region region:regions){
            Departement[] departements = restTemplate.getForObject(
                    PLACE_API_URL + "regions/" + region.getCode() + "/departements?fields=nom,code", Departement[].class);
            for(Departement departement:departements){
                Place[] citie = restTemplate.getForObject(PLACE_API_URL + "departements/" + departement.getCode() + "/communes?fields=nom,code", Place[].class);
                for(Place city:citie){
                    cities.add(city);
                    Weather w  = restTemplate.getForObject(WEATHER_API_URL + city.getNom(), Weather.class);
                    if(w.getFcst_day_3() != null){
                        for(Activity activity:activities){
                            List<User> receivers = userRepository.findAllByActivityAndPlace(activity.getName(), city.getNom());
                            for (User user : receivers) {
                                mailService.sendEmail(user.getEmail(), "WeekendPlanning Notification",
                                        "Vous êtes passioné par le/la" + activity.getName() +
                                                "Faite un tour à " + city.getNom() + " ce weekend en date" + w.getFcst_day_3().getDate() + " , et profitez en", false, true);
                            }
                        }
                    }
                }
            }
        }

    }
}
