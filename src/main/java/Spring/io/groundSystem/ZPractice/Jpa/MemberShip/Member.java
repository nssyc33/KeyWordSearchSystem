package Spring.io.groundSystem.ZPractice.Jpa.MemberShip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "TB_MEMBER")
@ToString
public class Member implements Serializable{
	
	@Id 
	@Column(columnDefinition = "number (9)")
	private Integer id;

	@Column(columnDefinition = "varchar (10)")
	private String barCd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarCd() {
		return barCd;
	}

	public void setBarCd(String barCd) {
		this.barCd = barCd;
	}
}
