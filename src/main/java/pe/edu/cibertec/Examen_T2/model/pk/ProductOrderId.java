package pe.edu.cibertec.Examen_T2.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductOrderId {

    private Integer orderid;
    private Integer productid;

}
