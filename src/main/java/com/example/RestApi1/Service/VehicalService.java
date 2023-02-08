package com.example.RestApi1.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.RestApi1.Exception.NoSuchVehicalExistsException;
import com.example.RestApi1.Exception.VehicalAlreadyExistsException;
import com.example.RestApi1.Repository.VehicalRepository;
import com.example.RestApi1.model.t_campaign;

@Service
public class VehicalService {
	 @Autowired
	 private VehicalRepository vehicalRepository;
	 
	
	 public List<t_campaign> getAllCampaign() {
		 System.out.println("Hello");
			return vehicalRepository.findAll();
		}
	 
	 
	 public t_campaign saveCampaign(t_campaign CampaignRegistration) {
			return vehicalRepository.save(CampaignRegistration);
		}
	 
	 public t_campaign updateCampaign(t_campaign campaignregistration, Integer id) {

		 t_campaign result = vehicalRepository.save(campaignregistration);
			return result;
		}
	 
	 public void deleteCampaign(Integer id) {
			
		 vehicalRepository.deleteById(id);
		}
	 
	public t_campaign getCampaignById(Integer id) {
			return vehicalRepository.findById(id)
					.orElseThrow();

		}
	 
	//-----------Create Campaign--------------------
	/* public String createCampaign(t_campaign tcampaign)
	 {
		t_campaign existingVehical= vehicalRepository.findById(tcampaign.getId()).orElse(null);
	    if (existingVehical == null) {
	        	vehicalRepository.save(tcampaign);
	            return "Vehical added successfully";
	     }
	     else
	    	 	throw new VehicalAlreadyExistsException("Vehical already exists!!");
	    
	  }
	 public t_campaign createCampaign(t_campaign tcampaign)
	 {
		t_campaign existingVehical= vehicalRepository.findById(tcampaign.getId()).orElse(null);
	    if (existingVehical == null) {
	        	return vehicalRepository.save(tcampaign);
	           // return "Vehical added successfully";
	     }
	     else
	    	 	throw new VehicalAlreadyExistsException("Vehical already exists!!");
	    
	  }
	 
	//-----------List of all Campaign--------------------
	 public List<t_campaign> getAllCampaign(t_campaign tcampaign) {
			// TODO Auto-generated method stub
			return vehicalRepository.findAll();
	 }
	 
	//-----------Update Campaign--------------------
	public String updateCampaigns(t_campaign tcampaign)
	{
			t_campaign existingvehical= vehicalRepository.findById(tcampaign.getId()).orElse(null);
	        if (existingvehical == null) {
	            throw new NoSuchVehicalExistsException("No Such vehical exists!!");
	        }
	        else {
	        	existingvehical.setName(tcampaign.getName());
	            vehicalRepository.save(existingvehical);
	            return "Record updated Successfully";
	        }
	    }
	
	//-----------@Delete Campaign by id--------------------
	 public String deleteCampaigns(int id)   
	 {  
		 t_campaign existingvehical= vehicalRepository.findById(id).orElse(null);
		 if (existingvehical == null) {
	            throw new NoSuchVehicalExistsException("No Such vehical exists!!");
	        }
		 else {
				 vehicalRepository.deleteById(id);
				 return "record deleted Successfully";
		 }
		 
	 }
	 */
	//-----------Search Campaign by id--------------------
	/* public Optional<t_campaign> searchCampaign(int id)
	 {
	        return vehicalRepository.findById(id).orElseThrow(()-> new NoSuchElementException(
	                    "No Such vehical exists with ID = " + id));
	                    t_campaign existingvehical= vehicalRepository.findById(id).orElse(null);
		 if (existingvehical == null) {
	            throw new NoSuchVehicalExistsException(
	                "No Such vehical exists!!");
	        }
		 else {
			 	return vehicalRepository.findById(id);
				  
		 }
	    }*/
	
	/*//-----------Update Campaign--------------------
	 * public t_campaign updateCampaigns(t_campaign tcampaign,int id)
    {
		t_campaign existingvehical
            = vehicalRepository.findById(tcampaign.getId())
                  .orElse(null);
        if (existingvehical == null)
            throw new NoSuchCustomerExistsException(
                "No Such Customer exists!!");
        else {
        	existingvehical.setName(tcampaign.getName());
            vehicalRepository.save(existingvehical);
            return "Record updated Successfully";
        }
    }*/
	
	 
	

	


	 

}
