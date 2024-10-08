package pe.edu.cibertec.Examen_T2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Examen_T2.dto.CustomerDto;
import pe.edu.cibertec.Examen_T2.dto.GenericResponseDto;
import pe.edu.cibertec.Examen_T2.service.ICustomerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> obtenerClienteXCiudad(
            @RequestParam("city") String city
    ){
        List<CustomerDto> customerDtoList = customerService.findByCity(city);
        if(customerDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(false).mensaje("No existen clientes")
                    .build(), HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(true).mensaje("Listado de clientes por ciudad")
                    .respuesta(customerDtoList).build(), HttpStatus.OK);
        }
    }

}
