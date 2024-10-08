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

    //Select * From Customer where city = :city
    List<Customer> findByCity(String city);

    //Select * From Customer where country = :country and city = :city
    List<Customer> findByCountryAndCity(String country, String city);

    //Select * From Customer where contactname like '%:contactname%'
    List<Customer> findByContactnameContaining(String contactname);

    //Select * From Customer where postalcode between :valorInicial and :valorFinal
    List<Customer> findByPostalcodeBetween(String postalCodeInicial,
                                           String postalCodeFinal);

    @Query(value = "SELECT c FROM Customer c WHERE c.city=:city and c.country=:country")
    List<Customer> buscarClientesXCityCountry(
            @Param("city") String city,
            @Param("country") String country
    );

    @Query(value = "SELECT c FROM Customer c WHERE c.contactname LIKE '%:contactname")
    List<Customer> buscarClientesXContactname(
            @Param("contactname") String contactname
    );

    @Query(value = "SELECT c.country AS country, COUNT(c) AS customercount " +
            "FROM Customer c GROUP BY c.country")
    List<CustomerCountCountryProjection> listarPaisesContarClientes();

    @Transactional
    @Modifying
    @Procedure(procedureName = "GenerateAndInsertCustomer")
    void registrarCliente(
            @Param("companyName") String companyname,
            @Param("contactName") String contactname,
            @Param("contactTitle") String contacttitle,
            @Param("address") String address,
            @Param("city") String city,
            @Param("postalCode") String postalcode,
            @Param("country") String country,
            @Param("phone") String phone);

}
