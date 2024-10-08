package pe.edu.cibertec.Examen_T2.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.Examen_T2.model.Product;
import pe.edu.cibertec.Examen_T2.repository.ProductRepository;
import pe.edu.cibertec.Examen_T2.service.IProductService;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    @Override
    public Product registrarProducto(Product product) {

        if (product == null || product.getProductname() == null ||
                product.getUnitprice() == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo " +
                    "y debe tener un nombre y un precio.");
        }
        return productRepository.save(product);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Product> obtenerProductosMayoresXStock(int stock) {
        return List.of();
    }

}
