package pe.edu.cibertec.Examen_T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.Examen_T2.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByUnitsinstockGreaterThan(int stock);


    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerateAndInsertProduct")
    void registrarProducto(
            @Param("ProductID") String ProductID,
            @Param("ProductName") String ProductName,
            @Param("SupplierID") String SupplierID,
            @Param("CategoryID") String CategoryID,
            @Param("QuantityPerUnit") String QuantityPerUnit,
            @Param("UnitPrice") String UnitPrice,
            @Param("UnitsInStock") String UnitsInStock);
}
