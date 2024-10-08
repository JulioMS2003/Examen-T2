package pe.edu.cibertec.Examen_T2.service;

import pe.edu.cibertec.Examen_T2.dto.CustomerDto;
import pe.edu.cibertec.Examen_T2.model.Customer;
import pe.edu.cibertec.Examen_T2.repository.projection.CustomerCountCountryProjection;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> findByCity(String city);

    List<CustomerDto> findByCountryAndCity(String country, String city);

    List<CustomerDto> findByContactnameContaining(String contactname);

    List<CustomerDto> findByPostalcodeBetween(String postalCodeInicial,
                                           String postalCodeFinal);

    List<CustomerDto> buscarClientesXCityCountry(String city, String country);

    List<CustomerCountCountryProjection> listarPaisesContarClientes();

}
