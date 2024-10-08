package pe.edu.cibertec.Examen_T2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.Examen_T2.dto.OrderDetailDto;
import pe.edu.cibertec.Examen_T2.dto.OrderDto;
import pe.edu.cibertec.Examen_T2.model.Customer;
import pe.edu.cibertec.Examen_T2.model.Employee;
import pe.edu.cibertec.Examen_T2.model.Order;
import pe.edu.cibertec.Examen_T2.repository.OrderRepository;
import pe.edu.cibertec.Examen_T2.service.IOrderDetailService;
import pe.edu.cibertec.Examen_T2.service.IOrderService;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final IOrderDetailService orderDetailService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Order nuevaOrden(OrderDto orderDto) {
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerid(orderDto.getCustomerid());
        Employee employee = new Employee();
        employee.setEmployeeid(orderDto.getEmployeeid());
        order.setCustomer(customer);
        order.setEmployee(employee);
        Order newOrder = orderRepository.save(order);
        for(OrderDetailDto orderDetailDto : orderDto.getOrderDetailDto()){
            orderDetailDto.setOrderid(newOrder.getOrderid());
            orderDetailService.registrarOrderDetail(orderDetailDto);
        }
        return newOrder;
    }

}
