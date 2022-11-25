package Spring.io.groundSystem.ZPractice.Jpa.MemberShip;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "TB_POINT")
@ToString
public class Point implements Serializable{
	
	@Id @Column(columnDefinition = "varchar (10)")
	private String barCd;

	@Id @Column(columnDefinition = "varchar (2)")
	private String jobCd;
	
	@Column(columnDefinition = "Number (10000000)")
	private Long point;

	public String getBarCd() {
		return barCd;
	}

	public void setBarCd(String barCd) {
		this.barCd = barCd;
	}

	public String getJobCd() {
		return jobCd;
	}

	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	
}
