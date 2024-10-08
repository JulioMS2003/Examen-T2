package pe.edu.cibertec.Examen_T2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> obtenerClientesXCiudad(
            @RequestParam("city") String city
    ){
        List<CustomerDto> customerDtoList = customerService.findByCity(city);
        if(customerDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(false)
                    .mensaje("No existe clientes").build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(GenericResponseDto.
                    <List<CustomerDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes por ciudad")
                    .respuesta(customerDtoList).build(), HttpStatus.OK);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<String>> registrarCliente(
            @RequestBody CustomerDto customerDto
    ){
        try{
            customerService.registrarCustomer(customerDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Cliente registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Cliente NO registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
