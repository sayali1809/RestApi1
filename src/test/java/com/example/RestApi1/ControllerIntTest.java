package com.example.RestApi1;

import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.example.RestApi1.model.t_campaign;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApi1Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntTest {

	@LocalServerPort
	private int localServerPort;

	@Autowired
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testCampaignRegisterationSuccess() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + localServerPort + "/api/campaigns/insert";
		// URI uri = new URI(baseUrl);

		/*
		 * Map<String, String> map = Map.ofEntries(entry("en", "message in english"),
		 * entry("ja", "Japanese message"), entry("ch", "Chinese sentence"));
		 */

		t_campaign campaign = new t_campaign(3, 1003, "suzuki", "suzuki", "Vehical Details", "map", 1, LocalDate.now(),
				LocalDate.now(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, 81, 81, "83", 84, 85, 86, 87, 88, "89", 90,
				90, LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), LocalDate.now(), Boolean.FALSE,
				LocalDate.now(), LocalDate.now());

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<t_campaign> request = new HttpEntity<>(campaign, headers);

		ResponseEntity<t_campaign> result = restTemplate.postForEntity(baseUrl, request, t_campaign.class);

		// Verify request succeed
		Assertions.assertEquals(3, result.getBody().getId());
	}

	@Test
	public void testgetAllCampaignRegistrationsSuccess() throws Exception {

		final String baseUrl = "http://localhost:" + localServerPort + "/api/campaigns/getAll";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<ArrayList> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ArrayList.class);

		Assertions.assertEquals(3, result.getBody().size());
	}

	@Test
	public void test_getCampaignById() throws Exception {
		final String baseUrl = "http://localhost:" + localServerPort + "/api/campaigns/1";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<t_campaign> request = new HttpEntity<>(null, headers);

		ResponseEntity<t_campaign> result = restTemplate.exchange(uri, HttpMethod.GET, request, t_campaign.class);

		Assertions.assertEquals(2, result.getBody().getId());
	}

	@Test
	public void test_deleteCampaign() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + localServerPort + "/api/campaigns/1";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<t_campaign> request = new HttpEntity<>(null, headers);

		ResponseEntity<t_campaign> result = restTemplate.exchange(uri, HttpMethod.GET, request, t_campaign.class);
		
		 restTemplate.delete(baseUrl);
		 t_campaign deletedcamp = restTemplate.getForObject(baseUrl, t_campaign.class);
		 assertNotNull(deletedcamp);
		// assertEquals(HttpStatus.OK, deletedcamp.getStatusCode());
	//	Assertions.assertEquals(2, result.getBody().getId());
		
	}

	@Test
	public void testUpdateEmployee() {
		final String baseUrl = "http://localhost:" + localServerPort +"/api/campaigns/3"; 
		// URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders(); 
		headers.set("X-COM-PERSIST","true");
		HttpEntity<t_campaign> request = new HttpEntity<>(null, headers);
		ResponseEntity<t_campaign> result = restTemplate.exchange(baseUrl,HttpMethod.GET, request, t_campaign.class);
		t_campaign campaign =restTemplate.getForObject(baseUrl, t_campaign.class);
		campaign.setParent_id(103); 
		campaign.setName("SUZUKI");
		restTemplate.put(baseUrl, campaign); 
		t_campaign updatedcamp =restTemplate.getForObject(baseUrl, t_campaign.class);
		assertNotNull(updatedcamp);

	}

}
