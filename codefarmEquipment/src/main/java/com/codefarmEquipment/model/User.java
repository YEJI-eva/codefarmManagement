package  com.codefarmEquipment.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;


//데이터 베이스 연동을 위한 모델 클래스
@Entity
@Data
public class User {
	@Id //pk
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//board_no 자동
	private Long id;

	private String username;
	private String password;
	private Boolean enabled;

	 @ManyToMany
	    @JoinTable(
	            name = "user_role",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<Role> roles = new ArrayList<>();

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Board> boards = new ArrayList<>();
	    

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Equipment> equipments = new ArrayList<>();
	    

}
