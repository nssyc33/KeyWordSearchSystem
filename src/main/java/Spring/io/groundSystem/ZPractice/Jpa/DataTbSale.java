package Spring.io.groundSystem.ZPractice.Jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Table(name = "TB_SALE")
@Entity
public class DataTbSale {
	
	@Id
    @GeneratedValue
    private int rn;

    @Column(name = "sale_month", nullable = false)
    private String saleMonth;

    @Column(name = "sale_kind", nullable = false)
    private String saleKind;

    @Column(name = "sale_amt", nullable = false)
    private int saleAmt;
}
