package Spring.io.groundSystem.ZPractice.Jpa.MemberShip;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "TB_POINT_HISTORY")
@ToString
public class PointHistory implements Serializable{
	
	@Id 
	@Column(columnDefinition = "varchar (10)")
	private String barCd;

	@Column(columnDefinition = "varchar (2)")
	private String jobCd;

	@Column(columnDefinition = "varchar (9)")
	private String storeCd;
	
	@Column(columnDefinition = "varchar (2)")
	private String KindCd;
	
	@Column
	private Date execDttm;

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

	public String getStoreCd() {
		return storeCd;
	}

	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}

	public String getKindCd() {
		return KindCd;
	}

	public void setKindCd(String kindCd) {
		KindCd = kindCd;
	}

	public Date getExecDttm() {
		return execDttm;
	}

	public void setExecDttm(Date execDttm) {
		this.execDttm = execDttm;
	}

	
}
