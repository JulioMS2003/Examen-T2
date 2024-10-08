package pe.edu.cibertec.Examen_T2.service;

import pe.edu.cibertec.Examen_T2.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category guardarCategoria(Category category);

    List<Category> obtenerCategorias();

    Optional<Category> obtenerCategoria(Integer id);

    Optional<Category> obtenerCategoriaXnombre(String categoryname);
}
