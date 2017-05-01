package models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID", nullable = false)
    private int productId;
    @Column(name = "price")
    private Double price;
    @Column(name = "availability")
    private Byte availability;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;


    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getAvailability() {
        return availability;
    }
    public void setAvailability(Byte availability) {
        this.availability = availability;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="stepId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("stepId")
    public Step getStep() {
        return step;
    }
    public void setStep(Step step) {
        this.step = step;
    }
}
