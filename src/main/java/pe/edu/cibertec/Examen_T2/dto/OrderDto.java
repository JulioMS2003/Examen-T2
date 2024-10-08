package pe.edu.cibertec.Examen_T2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OrderDto {

    private String customerid;
    private Integer employeeid;
    private List<OrderDetailDto> orderDetailDto;

}
