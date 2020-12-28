package com.codefarmEquipment.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

//데이터 베이스 연동을 위한 모델 클래스
@Entity
@Data
public class Purchase {
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // board_no 자동
	private Long purchase_no;
	private String device_gbcd;
	private int group_no;
	private int sort;
	@NotNull
	@Size(min = 2, max = 30, message = "사용자를 입력하세요.")
	private String manufacturer;
	private String supplier;
	@Column(nullable = false, name = "device_name")
	private String deviceName;
	private String serial_number;
	private int price;
	private Date purchase_dt;
	private String note;
	private Long order_id;
	private String update_id;
	private String insert_id;

	
	  @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval =
	  true) private List<Equipment> equipments = new ArrayList<>();
	 
}
