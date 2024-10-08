package pe.edu.cibertec.Examen_T2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto {

    private String customerid;
    private String companyname;
    private String contactname;
    private String contacttitle;
    private String address;
    private String city;
    private String postalcode;
    private String country;
    private String phone;

}
