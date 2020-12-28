package  com.codefarmEquipment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


//데이터 베이스 연동을 위한 모델 클래스
@Entity
@Data
public class Board {
	@Id //pk
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//board_no 자동
	private Long board_no;
	private int comm_cd;
	private int up_comm_cd;
	private int group_no;
	private int sort;
	@NotNull
	@Size(min=2,max=30, message = "제목은 2자이상 30자 이하입니다.")
	private String title;
	private String content;
	private Date update_dt;
	private String update_id;
	private String update_ip;
	private Date insert_dt;
	private String insert_id;
	private String insert_pg;
	private String insert_ip;
	
    @ManyToOne	//다대일 관계
    @JoinColumn(name = "user_id",referencedColumnName="id")
    @JsonIgnore
    private User user;
		
}
