package pe.edu.cibertec.Examen_T2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.Examen_T2.dto.OrderDetailDto;
import pe.edu.cibertec.Examen_T2.model.OrderDetail;
import pe.edu.cibertec.Examen_T2.model.pk.ProductOrderId;
import pe.edu.cibertec.Examen_T2.repository.OrderDetailRepository;
import pe.edu.cibertec.Examen_T2.service.IOrderDetailService;

@RequiredArgsConstructor
@Service
public class OrderDetailService implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public OrderDetail registrarOrderDetail(OrderDetailDto orderDetailDto) {
        //Construyo el ID
        ProductOrderId productOrderId = new ProductOrderId();
        productOrderId.setProductid(orderDetailDto.getProductid());
        productOrderId.setOrderid(orderDetailDto.getOrderid());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(productOrderId);
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        return orderDetailRepository.save(orderDetail);
    }

}
