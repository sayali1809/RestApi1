package com.example.RestApi1.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.RestApi1.Repository.VehicalRepository;
import com.example.RestApi1.Service.VehicalService;
import com.example.RestApi1.model.t_campaign;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = { ServiceMockitoTest.class })
public class ServiceMockitoTest {
	@Mock
	VehicalRepository vehicalRepository;

	@InjectMocks
	VehicalService vehicalService;
	
	@Test
	@Order(1)
	public void test_getAllCampaign() {

		t_campaign campaign = new t_campaign();
		campaign.setId(2);
		campaign.setParent_id(102);
		campaign.setName("suzuki");
		campaign.setNickname("suzuki");
		
		t_campaign cr = new t_campaign(4,104,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		
	/*	t_campaign cr=new t_campaign(6,106,"suzuki","suzuki", null, null, 0,null, null, null, null, true,true, true, 0,0,null,0,0,
					0,0,0,0,0,0,null,null, null, null,null, true,null,null);*/
		List<t_campaign> listcampregister = new ArrayList<t_campaign>();
		listcampregister.add(campaign);
		listcampregister.add(cr);

		when(vehicalRepository.findAll()).thenReturn(listcampregister);// mocking
		assertEquals(2, vehicalService.getAllCampaign().size());

	}
	@Test
	@Order(2)
	public void createCampaign() {

		t_campaign campaign = new t_campaign();
		campaign.setId(2);
		campaign.setParent_id(102);
		campaign.setName("suzuki");
		campaign.setNickname("suzuki");
		when(vehicalRepository.save(campaign)).thenReturn(campaign);// mocking
		assertEquals(campaign, vehicalService.saveCampaign(campaign));
	}
	
	@Test
	@Order(3)
	public void test_updateCampaignRegistration() {

		t_campaign campaign = new t_campaign(2,102,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		when(vehicalRepository.save(campaign)).thenReturn((campaign));// mocking
		int campaignid = 2;
		assertEquals(campaign, vehicalService.updateCampaign(campaign, campaignid));

	}
	
	@Test
	@Order(4)
	public void test_deleteCampaign() {
		t_campaign campaign = new t_campaign(2,102,"suzuki","suzuki","Vehical Details","map",1,
				LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
				81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
				LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now());
		int campid = campaign.getId();
		vehicalService.deleteCampaign(campid);
		verify(vehicalRepository, times(1)).deleteById(2);

	}
	
	@Test
	@Order(5)
	public void test_getCampaignById() {
		Optional<t_campaign> cr = Optional
				.ofNullable(new t_campaign(4,104,"suzuki","suzuki","Vehical Details","map",1,
						LocalDate.now(), LocalDate.now(),Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,81,
						81,"83", 84, 85, 86, 87, 88,"89", 90,90,LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(),
						LocalDate.now(),Boolean.FALSE, LocalDate.now(), LocalDate.now()));
		when(vehicalRepository.findById(1)).thenReturn(cr);
		assertEquals(4, vehicalService.getCampaignById(1).getId());
	}
	
}
