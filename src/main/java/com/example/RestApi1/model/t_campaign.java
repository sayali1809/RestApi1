package com.example.RestApi1.model;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.websocket.Decoder.Binary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_campaign")
public class t_campaign {
	
	@Id
	private int id;
	private int parent_id;
	private String name;
	private String nickname;
	private String description;
	private String Message;
	
	//private Map<String,String> Message;
	private int kind;
	
	@CreationTimestamp
	private LocalDate execution_date;
	
	@UpdateTimestamp
	private LocalDate end_date;
	
	private boolean condition1;
	private boolean condition2;
	private boolean condition3;
	private int updated_user_notification_info_file_id;
	private int rxswin_update_info_file_id;
	private String notification_number;
	private int package_kind;
	private int filter_conditions_type;
	private int reprodata_id;
	private int software_type;
	private int package_id;
	private String managed_id;
	private int state;
	private int evaluation_state;
	@CreationTimestamp
	private LocalDate approved_at;
	@CreationTimestamp
	private LocalDate executed_at;
	@CreationTimestamp
	private LocalDate cancelled_at;
	@CreationTimestamp
	private LocalDate evaluation_approved_at;
	@CreationTimestamp
	private LocalDate evaluation_cancelled_at;
	private boolean editable;
	@CreationTimestamp
	private LocalDate updated_at;
	@CreationTimestamp
	private LocalDate created_at;
	
	
}
