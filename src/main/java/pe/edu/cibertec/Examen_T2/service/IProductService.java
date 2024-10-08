package pe.edu.cibertec.Examen_T2.service;

import pe.edu.cibertec.Examen_T2.model.Product;

import java.util.List;

public interface IProductService {

    Product registrarProducto(Product product);

    List<Product> obtenerProductosMayoresXStock(int stock);

}
