package pe.edu.cibertec.Examen_T2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Examen_T2.exception.ResourceNotFoundException;
import pe.edu.cibertec.Examen_T2.model.Category;
import pe.edu.cibertec.Examen_T2.service.ICategoryService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> listarCategorias() {
        List<Category> categoryList =
                categoryService.obtenerCategorias();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoriaXid(
            @PathVariable Integer id) {
        Category category = categoryService.obtenerCategoria(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria" +
                " con el id" + id + "no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Category> obtenerCategoriaXnombre(
            @RequestParam String categoryname) {
        Category category = categoryService.obtenerCategoriaXnombre(categoryname)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria" +
                        " con el nombre" + categoryname + "no existe"));
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Category> registrarCategoria(
            @RequestBody Category category
    ){
        return new ResponseEntity<>(
                categoryService.guardarCategoria(category),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Category category
    ){
        Category currentCategory = categoryService.obtenerCategoria(id)
                .orElseThrow(() -> new ResourceNotFoundException("la categoria" +
                        " con el id = " + id + ", no existe"));
        currentCategory.setCategoryname(category.getCategoryname());
        currentCategory.setDescription(category.getDescription());
        return new ResponseEntity<>(
                categoryService.guardarCategoria(currentCategory),
                HttpStatus.ACCEPTED);
    }

}
