package com.example.RestApi1.Repository;

import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RestApi1.model.t_campaign;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Repository
public interface VehicalRepository extends JpaRepository<t_campaign, Integer>{

}
