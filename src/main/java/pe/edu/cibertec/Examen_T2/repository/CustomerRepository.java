package pe.edu.cibertec.Examen_T2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.Examen_T2.model.Customer;
import pe.edu.cibertec.Examen_T2.repository.projection.CustomerCountCountryProjection;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByCity(String city);
    List<Customer> findByCountryAndCity(String country, String city);
    List<Customer> findByContactnameContaining(String contactname);
    List<Customer> findByPostalcodeBetween(String postalCodeInicial,
                                           String postalCodeFinal);
    List<Customer> findByCompanynameContainingOrderByCompanynameAsc(
            String companyname);

    @Query(value = "SELECT c FROM Customer c WHERE c.city=:city " +
            "and c.country=:country")
    List<Customer> buscarClientesXCityCountry(
            @Param("city") String city,
            @Param("country") String country);

    @Query(value = "SELECT c.country AS country, COUNT(c) AS customercount " +
            "FROM Customer c GROUP BY c.country")
    List<CustomerCountCountryProjection> listaPaisesConCantidadClientes();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Customer SET address=:address WHERE customerid=:customerid")
    void actualizarDireccionCliente(@Param("address") String address,
                                    @Param("customerid") String customerid);


    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerarCustomer")
    void registrarCliente(
            @Param("companyName") String companyName,
            @Param("contactName") String contactName,
            @Param("contactTitle") String contactTitle,
            @Param("address") String address,
            @Param("city") String city,
            @Param("region") String region,
            @Param("postalCode") String postalCode,
            @Param("country") String country,
            @Param("phone") String phone,
            @Param("fax") String fax);

}
