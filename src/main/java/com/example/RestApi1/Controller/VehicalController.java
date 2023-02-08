package com.example.RestApi1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.RestApi1.Exception.ErrorResponse;
import com.example.RestApi1.Repository.VehicalRepository;
import com.example.RestApi1.Service.VehicalService;
import com.example.RestApi1.model.t_campaign;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/campaigns")
public class VehicalController {
	
	@Autowired
	VehicalService vehicalService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<t_campaign>> getAllCampaign() {
		try {
			List<t_campaign> cpr = vehicalService.getAllCampaign();
			return new ResponseEntity<List<t_campaign>>(cpr, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<t_campaign> saveCampaign(
			@RequestBody t_campaign campaignregistration) {
		return new ResponseEntity<t_campaign>(vehicalService.saveCampaign(campaignregistration),
				HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<t_campaign> updateCampaign(@PathVariable("id") Integer id,
			@RequestBody t_campaign campaignregistration) {
		return new ResponseEntity<t_campaign>(
				vehicalService.updateCampaign(campaignregistration, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCampaign(@PathVariable("id") Integer id) {

		// delete CampaignRegistration from DB
		vehicalService.deleteCampaign(id);

		return new ResponseEntity<String>("CampaignRegistration deleted successfully!! with  the id   " + " " + id,
				HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<t_campaign> getCampaignById(
			@PathVariable("id") Integer campaignregistrationid) {
		return new ResponseEntity<t_campaign>(
				vehicalService.getCampaignById(campaignregistrationid), HttpStatus.FOUND);
	}
	
	/*
	//-----------Create Campaign--------------------
	@PostMapping("/campaigns")
    public t_campaign createCampaign(@RequestBody t_campaign tcampaign)
    {
        return vehicalService.createCampaign(tcampaign);
    }
	
	//-----------List of all Campaign--------------------
	@GetMapping("/campaigns")
	public List<t_campaign> getAllCampaign(@RequestBody t_campaign tcampaign){
		return vehicalService.getAllCampaign(tcampaign);
	}
	
	//-----------Update Campaign--------------------
	@PutMapping("/campaigns")
	public String updateCampaigns(@RequestBody t_campaign tcampaign)
	{
	    return vehicalService.updateCampaigns(tcampaign);
	}
	
	//-----------@Delete Campaign by id--------------------
	@DeleteMapping("/campaigns/{id}")  
	private String deleteCampaigns(@PathVariable("id") int id)   
	{  
		return vehicalService.deleteCampaigns(id);  
	}  
	
	//-----------Search Campaign by id--------------------
	@GetMapping("/campaigns/{id}")
	public Optional<t_campaign> searchCampaign(@PathVariable("id") int id)
	{
	    return vehicalService.searchCampaign(id);
	}
	
	
	
	//-----------Update Campaign--------------------
	 @PutMapping("/campaigns/{id}")  
	 private t_campaign updateCampaigns(@RequestBody t_campaign tcampaign ,@PathVariable("id") int id)   
	 {  
		  return vehicalService.updateCampaigns(tcampaign,id);
	 }*/
	
	 
	 
	
}
