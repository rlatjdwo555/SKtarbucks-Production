package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Production_table")
public class Production {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String cafeId;
    private String cafeNm;
    private String custNm;
    private String status;

    @PostPersist
    public void onPostPersist(){
        ProductionCompleted productionCompleted = new ProductionCompleted();
        BeanUtils.copyProperties(this, productionCompleted);
        productionCompleted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){
        ProductionChanged productionChanged = new ProductionChanged();
        BeanUtils.copyProperties(this, productionChanged);
        productionChanged.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCafeId() {
        return cafeId;
    }

    public void setCafeId(String cafeId) {
        this.cafeId = cafeId;
    }
    public String getCafeNm() {
        return cafeNm;
    }

    public void setCafeNm(String cafeNm) {
        this.cafeNm = cafeNm;
    }
    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
