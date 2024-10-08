package pe.edu.cibertec.Examen_T2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.Examen_T2.dto.CustomerDto;
import pe.edu.cibertec.Examen_T2.model.Customer;

@Component
public class CustomerConvert {

    public CustomerDto convertirCustomerACustomerDto(Customer customer){
        return CustomerDto.builder().city(customer.getCity())
                .companyname(customer.getCompanyname())
                .contactname(customer.getContactname())
                .contacttitle(customer.getContacttitle())
                .fax(customer.getFax())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .country(customer.getCountry())
                .customerid(customer.getCustomerid())
                .region(customer.getRegion())
                .postalcode(customer.getPostalcode())
                .build();
    }

    public Customer convertirCustomerDtoACustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        customer.setCompanyname(customerDto.getCompanyname());
        customer.setAddress(customerDto.getAddress());
        customer.setFax(customerDto.getFax());
        customer.setContactname(customerDto.getContactname());
        customer.setContacttitle(customerDto.getContacttitle());
        customer.setPhone(customerDto.getPhone());
        customer.setPostalcode(customerDto.getPostalcode());
        customer.setRegion(customerDto.getRegion());
        return customer;
    }

}
