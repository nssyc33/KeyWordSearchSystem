package Spring.io.groundSystem.ZPractice.Jpa.MemberShip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "TB_STORE")
@ToString
public class Store implements Serializable{
	
	@Id 
	@Column(columnDefinition = "varchar (9)")
	private String storeCd;

	@Column(columnDefinition = "varchar (100)")
	private String name;

	@Column(columnDefinition = "varchar (2)")
	private String jobCd;

	public String getStoreCd() {
		return storeCd;
	}

	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobCd() {
		return jobCd;
	}

	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}

	
}
