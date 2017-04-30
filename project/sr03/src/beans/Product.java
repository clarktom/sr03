package beans;

import javax.persistence.*;

/**
 * Created by utilisateur on 17/04/2017.
 */

@Entity // Classe persistente
@Table(name="product")
public class Product { // implements Serializable
    private int productId;
    private Double price;
    private Byte availability;
    private int stepId;
//    private Step stepByStepId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "availability")
    public Byte getAvailability() {
        return availability;
    }

    public void setAvailability(Byte availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "stepID")
    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        if (productId != product.productId) return false;
//        if (stepId != product.stepId) return false;
//        if (price != null ? !price.equals(product.price) : product.price != null) return false;
//        if (availability != null ? !availability.equals(product.availability) : product.availability != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = productId;
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        result = 31 * result + (availability != null ? availability.hashCode() : 0);
//        result = 31 * result + stepId;
//        return result;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "stepID", referencedColumnName = "stepID", nullable = false,insertable = false, updatable =false)
//    public Step getStepByStepId() {
//        return stepByStepId;
//    }
//
//    public void setStepByStepId(Step stepByStepId) {
//        this.stepByStepId = stepByStepId;
//    }
}
