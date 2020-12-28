package  com.codefarmEquipment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


//데이터 베이스 연동을 위한 모델 클래스
@Entity
@Data
public class Role {
	@Id //pk
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//board_no 자동
	private Long id;

	private String name;
	
	
	@ManyToMany(mappedBy ="roles")
	@JsonIgnore
	private List<User> users;
	

}
