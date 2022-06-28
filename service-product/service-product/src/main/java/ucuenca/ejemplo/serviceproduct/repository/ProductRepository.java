package ucuenca.ejemplo.serviceproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucuenca.ejemplo.serviceproduct.entity.Categoria;
import ucuenca.ejemplo.serviceproduct.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
   public List<Product>findByCategory(Categoria category);
}
