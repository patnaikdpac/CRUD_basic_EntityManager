package com.deepak.employee;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
//@Table(name = "empl")
public class Employee implements Serializable
{
	private static final long serialVersionUID = -2891368724303039181L;
	
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name", length = 100)
	private String firstName;
	
	@Column(name = "last_name", length = 100)
	private String lastName;
	
	@Column(unique = true, length = 100)
	private String mail;
	
	@Column(unique = true, length = 12)
	private String mobile;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private int status;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a") //why have we written a at the end ? ask Sir
	private LocalDateTime creDate;
	
	@CreatedBy
	private String creUser;
	
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime modDate;
	
	@LastModifiedBy
	private String modUser;
	
	
}
