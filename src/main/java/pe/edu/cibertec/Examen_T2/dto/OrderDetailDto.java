package pe.edu.cibertec.Examen_T2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDetailDto {

    private Integer orderid;
    private Integer productid;
    private Integer quantity;

}
