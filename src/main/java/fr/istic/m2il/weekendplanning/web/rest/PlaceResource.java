package fr.istic.m2il.weekendplanning.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.m2il.weekendplanning.domain.Activity;
import fr.istic.m2il.weekendplanning.domain.Place;
import fr.istic.m2il.weekendplanning.domain.User;
import fr.istic.m2il.weekendplanning.repository.PlaceRepository;
import fr.istic.m2il.weekendplanning.service.dto.UserDTO;
import fr.istic.m2il.weekendplanning.web.rest.util.PaginationUtil;

@RestController
@RequestMapping("/api")
public class PlaceResource {
	
    @Autowired
    private final PlaceRepository placeRepository;
    
	public PlaceResource(PlaceRepository PlaceRepository) {
		this.placeRepository = PlaceRepository;
	}
//	
////	@PostMapping("/places")
////	public ResponseEntity choisePlaces(@Valid @RequestMapping ManagedUserVM managedUserVM) throws URISyntaxException{
////		if(managedUserVM.getId() != null) {
////			return ResponseEntity.badRequest()
////					.
////		}
////	}
//    
    @GetMapping("/places")
    //@Timed
    public ResponseEntity<List<Place>> getAllPlace(Pageable pageable) {
    	List<Place> listUser = placeRepository.findAllByUserId("0");
    	final Page<Place> page = new PageImpl<Place>(listUser);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/places");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    @PutMapping("/update_place")
    @Produces("application/json")
    public  ResponseEntity<Place> addPlace(){
    	Place newplace = new Place();
    	newplace.setNom("no");
    	newplace.setCode("7606");
    	placeRepository.save(newplace);
        return new ResponseEntity<Place>(newplace, HttpStatus.OK);
    }
    
}
