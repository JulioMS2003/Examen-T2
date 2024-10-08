package pe.edu.cibertec.Examen_T2.service;

import pe.edu.cibertec.Examen_T2.dto.OrderDto;
import pe.edu.cibertec.Examen_T2.model.Order;

public interface IOrderService {

    Order nuevaOrden(OrderDto orderDto);

}
