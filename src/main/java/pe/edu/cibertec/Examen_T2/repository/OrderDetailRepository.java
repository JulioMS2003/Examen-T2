package pe.edu.cibertec.Examen_T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.Examen_T2.model.OrderDetail;
import pe.edu.cibertec.Examen_T2.model.pk.ProductOrderId;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, ProductOrderId> {
}
