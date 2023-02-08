package com.example.RestApi1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.RestApi1.Controller.VehicalController;
import com.example.RestApi1.Service.VehicalService;
import com.example.RestApi1.model.t_campaign;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = { ControllerMockitoTest.class })
public class ControllerMockitoTest {
	@Mock
	VehicalService vehicalService;

	@InjectMocks
	VehicalController vehicalController;

	List<t_campaign> camplist;

	t_campaign campaign;
	
	@Test
	@Order(1)
	public void test_getAllCampaignRegistrations() {

		camplist = new ArrayList<t_campaign>();
		camplist.add(new t_campaign(1, 101, "ford", "ford", "Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now()));
		camplist.add(new t_campaign(2,102,"altroz","altroz","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now()));

		when(vehicalService.getAllCampaign()).thenReturn(camplist);// mocking
		ResponseEntity<List<t_campaign>> res = vehicalController.getAllCampaign();
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(2, res.getBody().size());
	}
	
	@Test
	@Order(2)
	public void test_addCampaignRegistration() {

		campaign = new t_campaign(3,103,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());

		when(vehicalService.saveCampaign(campaign)).thenReturn(campaign);// mocking
		ResponseEntity<t_campaign> res = vehicalController.saveCampaign(campaign);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(campaign, res.getBody());

	}
	
	@Test
	@Order(3)
	public void test_updateCampaign() {

		campaign = new t_campaign(3,103,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		int cmpgnid = 44;

		when(vehicalService.updateCampaign(campaign, cmpgnid)).thenReturn(campaign);// mocking
		ResponseEntity<t_campaign> res = vehicalController.updateCampaign(cmpgnid, campaign);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(44, res.getBody().getId());

	}

	@Test
	@Order(4)
	public void test_deleteCampaignById() {

		campaign = new t_campaign(3,103,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		
		int cmpgnid = campaign.getId();
		ResponseEntity<String> res  = vehicalController.deleteCampaign(cmpgnid);
		verify(vehicalService, times(1)).deleteCampaign(3);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		 

	}
	
	@Test
	@Order(5)
	public void test_getCampaignById() {

		campaign = new t_campaign(3,103,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		int cmpid = 3;
		when(vehicalService.getCampaignById(cmpid)).thenReturn(campaign);// mocking
		ResponseEntity<t_campaign> res = vehicalController.getCampaignById(cmpid);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(cmpid, res.getBody().getId());
	}
}
