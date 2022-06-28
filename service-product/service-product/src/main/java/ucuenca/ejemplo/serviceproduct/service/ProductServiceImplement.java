package ucuenca.ejemplo.serviceproduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ucuenca.ejemplo.serviceproduct.entity.Categoria;
import ucuenca.ejemplo.serviceproduct.entity.Product;
import ucuenca.ejemplo.serviceproduct.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImplement implements ProductService{


    private final ProductRepository productRepository;


    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productBD = getProduct(product.getId());
        if (null == productBD ){
            return null;
        }
        productBD.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setCategory(product.getCategory());
        product.setPrice(product.getPrice());
        return productRepository.save(productBD);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productBD = getProduct(id);
        if (null == productBD ){
            return null;
        }
        productBD.setStatus("DELETED");
        return productRepository.save(productBD);
    }

    @Override
    public List<Product> findByCategory(Categoria category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productBD = getProduct(id);
        if (null == productBD ){
            return null;
        }
        Double stock = productBD.getStock()+quantity;
        productBD.setStock(stock);
        return productRepository.save(productBD);
    }
}
