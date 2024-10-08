package pe.edu.cibertec.Examen_T2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Examen_T2.dto.CustomerDto;
import pe.edu.cibertec.Examen_T2.model.Customer;
import pe.edu.cibertec.Examen_T2.repository.CustomerRepository;
import pe.edu.cibertec.Examen_T2.repository.projection.CustomerCountCountryProjection;
import pe.edu.cibertec.Examen_T2.service.ICustomerService;
import pe.edu.cibertec.Examen_T2.util.convert.CustomerConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConvert customerConvert;

    @Override
    public List<CustomerDto> findByCity(String city) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByCity(city)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerDto> findByCountryAndCity(String country, String city) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByCountryAndCity(country, city)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerDto> findByContactnameContaining(String contactname) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByContactnameContaining(contactname)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerDto> findByPostalcodeBetween(String postalCodeInicial, String postalCodeFinal) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByPostalcodeBetween(postalCodeInicial, postalCodeFinal)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerDto> findByCompanynameContainingOrderByCompanynameAsc(String companyname) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByCompanynameContainingOrderByCompanynameAsc(companyname)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerDto> buscarClientesXCityCountry(String city, String country) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepository.buscarClientesXCityCountry(city, country)) {
            customerDtos.add(customerConvert
                    .convertirCustomerACustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public List<CustomerCountCountryProjection> listaPaisesConCantidadClientes() {
        return customerRepository.listaPaisesConCantidadClientes();
    }

    @Override
    public void registrarCustomer(CustomerDto customerDto) {
        customerRepository.registrarCliente(customerDto.getCompanyname(),
                customerDto.getContactname(),
                customerDto.getContacttitle(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getRegion(),
                customerDto.getPostalcode(),
                customerDto.getCountry(),
                customerDto.getPhone(),
                customerDto.getFax());

    }
}
