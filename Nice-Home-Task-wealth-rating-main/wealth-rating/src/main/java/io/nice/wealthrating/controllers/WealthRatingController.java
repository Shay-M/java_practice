package io.nice.wealthrating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nice.wealthrating.models.PersonData;
import io.nice.wealthrating.models.RichPerson;
import io.nice.wealthrating.services.WealthRatingService;


@RestController
@RequestMapping("/wealthRating")
public class WealthRatingController {
	
	@Autowired
	private WealthRatingService wealthRatingService;
	
	
	@GetMapping
	public ResponseEntity<List<RichPerson>> getAllRichPersons() {
		return new ResponseEntity<>(wealthRatingService.getAllRichPersons(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RichPerson> getRichPerson(@PathVariable long id) {
		RichPerson richPerson = wealthRatingService.getRichPerson(id);
		
		if(richPerson == null){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(richPerson, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RichPerson> submitPersonData(@RequestBody PersonData personData) {
		RichPerson newRichPerson = wealthRatingService.createRichPerson(personData);
		
		if(newRichPerson != null)
			return new ResponseEntity<>(newRichPerson, HttpStatus.CREATED);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	}
}
