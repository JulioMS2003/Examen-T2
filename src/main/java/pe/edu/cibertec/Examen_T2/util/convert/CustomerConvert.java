package pe.edu.cibertec.Examen_T2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.Examen_T2.dto.CustomerDto;
import pe.edu.cibertec.Examen_T2.model.Customer;

@Component
public class CustomerConvert {

    public CustomerDto convertirCustomerADto(Customer customer){
        return CustomerDto.builder().city(customer.getCity())
                .companyname(customer.getCompanyname())
                .contactname(customer.getContactname())
                .contacttitle(customer.getContacttitle())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .country(customer.getCountry())
                .customerid(customer.getCustomerid())
                .postalcode(customer.getPostalcode())
                .build();
    }

}
