package pe.edu.cibertec.Examen_T2.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import pe.edu.cibertec.Examen_T2.model.Category;
import pe.edu.cibertec.Examen_T2.model.OrderDetail;
import pe.edu.cibertec.Examen_T2.model.Supplier;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class ProductoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    //@Column(name = "productname")
    private String productname;
    private String quantityperunit;
    private Double unitprice;
    private Integer unitsinstock;
    private Integer unitsonorder;
    private Integer reorderlevel;
    private boolean discontinued;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<OrderDetail> order = new HashSet<>();

}
