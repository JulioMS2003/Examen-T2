package pe.edu.cibertec.Examen_T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.Examen_T2.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
