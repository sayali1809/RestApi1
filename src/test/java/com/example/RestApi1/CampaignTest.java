package com.example.RestApi1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.RestApi1.Repository.VehicalRepository;
import com.example.RestApi1.Service.VehicalService;
import com.example.RestApi1.model.t_campaign;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CampaignTest {

	@Autowired
	VehicalRepository vehicalRepository;
	
	private t_campaign campaign,camp;
	
	@BeforeEach
	public void setup() {
		campaign=new t_campaign();
		campaign.setId(14);
		campaign.setParent_id(111);
		campaign.setName("ford");
		campaign.setNickname("ford");
		
		camp=new t_campaign();
		camp.setId(2);
		camp.setParent_id(112);
		camp.setName("kia");
		camp.setNickname("kia");
	}
	
	@DisplayName("jUnit test for save campaign")
	@Test
	public void Test_addCampaign() {
		t_campaign savecampaign=vehicalRepository.saveAndFlush(camp);
		assertThat(savecampaign).isNotNull();
		assertThat(savecampaign.getId()).isEqualTo(2);
	}
	
	@DisplayName("jUnit test for all campaign")
	@Test
	public void Test_allCampaign() {
		List <t_campaign> allCamp=vehicalRepository.findAll();
		assertThat(allCamp).isNotNull();
		assertThat(allCamp.size()).isEqualTo(10);
	}
	

	@DisplayName("jUnit test for campaign by id")
	@Test
	public void Test_getByIdCampaign() {
		vehicalRepository.save(camp);
		t_campaign tcamp=vehicalRepository.findById(camp.getId()).get();
		assertThat(tcamp).isNotNull();
	}
	
	@DisplayName("jUnit test for update campaign")
	@Test
	public void Test_updateCampaign() {
		vehicalRepository.save(camp);
		t_campaign tcamp=vehicalRepository.findById(camp.getId()).get();
		tcamp.setName("kia");
		tcamp.setNickname("kia");
		t_campaign updatedcampid=vehicalRepository.save(tcamp);
				// then - verify the output
		assertThat(updatedcampid.getName()).isEqualTo("kia");
		assertThat(updatedcampid.getName()).isEqualTo("kia");
	}
	
	@DisplayName("JUnit test for delete campaign")
	@Test
	public void Test_deleteCampaign() {

		vehicalRepository.save(camp);
		vehicalRepository.deleteById(camp.getId());
		Optional<t_campaign> campoptional=vehicalRepository.findById(camp.getId());
				// then - verify the output
		assertThat(campoptional).isEmpty();
	}
}
	
	