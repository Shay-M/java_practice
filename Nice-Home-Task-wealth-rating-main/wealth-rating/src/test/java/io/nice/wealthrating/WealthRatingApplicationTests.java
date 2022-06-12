package io.nice.wealthrating;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.nice.wealthrating.controllers.WealthRatingController;
import io.nice.wealthrating.models.FinancialInfo;
import io.nice.wealthrating.models.PersonData;
import io.nice.wealthrating.models.PersonalInfo;
import io.nice.wealthrating.models.RichPerson;
import io.nice.wealthrating.services.CentralBankService;
import io.nice.wealthrating.services.WealthRatingService;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class WealthRatingApplicationTests {

	private static final Long CITY_EVALUATION = 10l;

	private static final Long WEALTH_THRESHOLD = 50l;

	@Autowired
	private WealthRatingController wealthRatingController;

	@MockBean
	private CentralBankService centralBankService;

	@InjectMocks
	private WealthRatingService wealthRatingService;
	

	@BeforeEach
	void contextLoads() {
		when(centralBankService.getCityEvaluation(anyString())).thenReturn(CITY_EVALUATION);
		when(centralBankService.getWealthThreshold()).thenReturn(WEALTH_THRESHOLD);
	}

	private PersonData createPersonData(long id, long cash, int numberOfAssets) {
		PersonalInfo personalInfo = createPersonalInfo(id);
		FinancialInfo financialInfo = createFinancialInfo(cash, numberOfAssets);
		
		return new PersonData(id, personalInfo, financialInfo);
	}
	
	private PersonalInfo createPersonalInfo(long id) {
		return new PersonalInfo("firstName_"+id, "lastName_"+id, "city_"+id);
	}
	
	private FinancialInfo createFinancialInfo(long cash, int numberOfAssets) {
		return new FinancialInfo(cash, numberOfAssets);
	}
	
	@Test
	void testAddRichPerson() {
		long cash = 10l;
		int numberOfAssets = 10; 
		
		PersonData personData = createPersonData(1l, cash,numberOfAssets);
		ResponseEntity<RichPerson> response = wealthRatingController.submitPersonData(personData);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		RichPerson richPerson = response.getBody();
		asserRichPersonIsAsPersonData(richPerson, personData);
		assertFortuneIsCorrect(cash, numberOfAssets, richPerson);
	}


	@Test
	void testAddNoneRichPerson_NotAcceptableResponse() {
		long cash = 1l;
		int numberOfAssets = 0; 
		
		PersonData personData = createPersonData(1l, cash,numberOfAssets);
		ResponseEntity<RichPerson> response = wealthRatingController.submitPersonData(personData);
		
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
		assertTrue(response.getBody()==null);
	}
	
	@Test
	void testGetRichPerson() {
		long cash = 10l;
		int numberOfAssets = 10; 
		
		PersonData personData = createPersonData(1l, cash,numberOfAssets);
		wealthRatingController.submitPersonData(personData);
		ResponseEntity<RichPerson> response = wealthRatingController.getRichPerson(personData.getId());
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		RichPerson richPerson = response.getBody();
		asserRichPersonIsAsPersonData(richPerson, personData);
		assertFortuneIsCorrect(cash, numberOfAssets, richPerson);
	}

	
	@Test
	void testGetRichPerson_MotFoundResponse() {
		ResponseEntity<RichPerson> response = wealthRatingController.getRichPerson(1);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testGetAllRichPersons() {
		long id = 1l;
		long cash = 10l;
		int numberOfAssets = 10; 
		PersonData personData1 = createPersonData(id, cash, numberOfAssets);
		wealthRatingController.submitPersonData(personData1);

		id = 2l; 
		cash = 20l;
		numberOfAssets = 20; 
		PersonData personData2 = createPersonData(id, cash, numberOfAssets);
		wealthRatingController.submitPersonData(personData2);

		ResponseEntity<List<RichPerson>> response = wealthRatingController.getAllRichPersons();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		List<RichPerson> richPersons = response.getBody();
		assertTrue(richPersons.size()==2);
		
		RichPerson richPerson = richPersons.stream().filter(rp -> rp.getId() == personData1.getId()).findFirst().get();
		asserRichPersonIsAsPersonData(richPerson, personData1);
		
		richPerson = richPersons.stream().filter(rp -> rp.getId() == personData2.getId()).findFirst().get();
		asserRichPersonIsAsPersonData(richPerson, personData2);
	}
	
	
	@Test
	void testGetAllRichPersons_NoRichPersons() {
		ResponseEntity<List<RichPerson>> response = wealthRatingController.getAllRichPersons();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		List<RichPerson> richPersons = response.getBody();
		assertTrue(richPersons.isEmpty());
	}

	@Test
	void testSubmittingTheSamePerson_ConflictResponse() {
		long id = 1l;
		long cash = 10l;
		int numberOfAssets = 10;
		PersonData personData = createPersonData(id, cash, numberOfAssets);
		wealthRatingController.submitPersonData(personData);

		try{
			ResponseEntity<RichPerson> response = wealthRatingController.submitPersonData(personData);
		} catch (ResponseStatusException e) {
			assertEquals("Person already exist",e.getReason());
			assertEquals(HttpStatus.CONFLICT, e.getStatus());
		}
	}

	private void asserRichPersonIsAsPersonData(RichPerson richPerson, PersonData personData) {
		assertEquals(personData.getId(), richPerson.getId());
		assertEquals(personData.getFirstName(), richPerson.getFirstName());
		assertEquals(personData.getLastName(), richPerson.getLastName());
	}
	
	private void assertFortuneIsCorrect(long cash, int numberOfAssets, RichPerson richPerson) {
		assertEquals(wealthRatingService.calculatedFortune(cash, numberOfAssets, CITY_EVALUATION), richPerson.getFortune());
	}
}
