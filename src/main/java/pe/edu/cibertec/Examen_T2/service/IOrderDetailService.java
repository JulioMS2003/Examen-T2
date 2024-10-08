package pe.edu.cibertec.Examen_T2.service;

import pe.edu.cibertec.Examen_T2.dto.OrderDetailDto;
import pe.edu.cibertec.Examen_T2.model.OrderDetail;

public interface IOrderDetailService {

    OrderDetail registrarOrderDetail(OrderDetailDto orderDetailDto);

}
