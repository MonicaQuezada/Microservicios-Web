package ucuenca.ejemplo.serviceproduct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ucuenca.ejemplo.serviceproduct.entity.Categoria;
import ucuenca.ejemplo.serviceproduct.entity.Product;
import ucuenca.ejemplo.serviceproduct.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenResturnListProduct(){
        Product product01 = Product.builder()
                .name("computer")
                .category(Categoria.builder().id(1L).build())
                .descripcion("")
                .stock(Double.parseDouble("10"))
                .precio(Double.parseDouble("1248.49"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);

    }
}
