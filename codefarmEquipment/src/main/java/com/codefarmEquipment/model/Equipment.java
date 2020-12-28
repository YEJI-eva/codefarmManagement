package com.codefarmEquipment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.codefarmEquipment.config.DeviceConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//데이터 베이스 연동을 위한 모델 클래스
@Entity
@Data
public class Equipment {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // board_no 자동
	private Long device_id;
	@Column(nullable = false, name = "device_gbcd")
	@Convert(converter=DeviceConverter.class)
	private String deviceGbcd;
	private int group_no;
	private int sort;
	private String location;

	/*
	 * @Column(nullable = false, name = "device_name") private String deviceName;
	 */

	private Date start_dt;
	private Date end_dt;
	private String avail_status;
	private Date availability_dt;
	private String note;
	private Long update_id;
	private Long insert_id;

	@ManyToOne // 다대일 관계

	@JoinColumn(name = "user_id", referencedColumnName = "id")

	@JsonIgnore
	private User user;

	
	  
	@ManyToOne //구매 관계
	  
	@JoinColumn(name = "purchase_no",referencedColumnName="purchase_no")

	@JsonIgnore
	private Purchase purchase;
	 

}
