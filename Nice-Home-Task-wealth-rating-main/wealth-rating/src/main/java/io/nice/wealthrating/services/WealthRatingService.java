package io.nice.wealthrating.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.nice.wealthrating.models.PersonData;
import io.nice.wealthrating.models.RichPerson;
import io.nice.wealthrating.repositories.WealthRatingRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WealthRatingService {
	
	@Autowired
	private WealthRatingRepository wealthRatingRepository;
	@Autowired
	private CentralBankService centralBankService;
	
	
	public List<RichPerson> getAllRichPersons(){
		return wealthRatingRepository.findAll();
	}
	
	public RichPerson getRichPerson(long id) {
		return wealthRatingRepository.findById(id).orElse(null);
	}

	public RichPerson createRichPerson(PersonData personData) {
		long cityEvaluation = centralBankService.getCityEvaluation(personData.getCity());
		long personFortune = calculatedFortune(personData, cityEvaluation);
		long wealthThreshold = centralBankService.getWealthThreshold();
		
		if(isRichPerson(personFortune, wealthThreshold)) {
			RichPerson richPerson = getRichPerson(personData.getId());

			if(richPerson == null) {
				richPerson = createRichPerson(personData, personFortune);
				return addRichPerson(richPerson);
			}

			throw new ResponseStatusException(HttpStatus.CONFLICT, "Person already exist");
		}
		 
		return null;
	}
	
	private RichPerson createRichPerson(PersonData personData, long fortune) {
		return new RichPerson(personData.getId(), personData.getFirstName(), personData.getLastName(), fortune);
	}
	
	private RichPerson addRichPerson(RichPerson richPerson) {
		return wealthRatingRepository.save(richPerson);
	}

	private boolean isRichPerson(long personFortune, long wealthThreshold) {
		return personFortune > wealthThreshold;
	}

	private long calculatedFortune(PersonData personData, long cityEvaluation) {
		return calculatedFortune(personData.getCash(), personData.getNumberOfAssets(), cityEvaluation);
	}
	
	public long calculatedFortune(long cash, int numberOfAssets, long cityEvaluation) {
		return cash + numberOfAssets * cityEvaluation;
	}
}
