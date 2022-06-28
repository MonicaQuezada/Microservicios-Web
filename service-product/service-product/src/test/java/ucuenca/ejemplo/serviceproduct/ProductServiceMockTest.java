package ucuenca.ejemplo.serviceproduct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ucuenca.ejemplo.serviceproduct.entity.Categoria;
import ucuenca.ejemplo.serviceproduct.entity.Product;
import ucuenca.ejemplo.serviceproduct.repository.ProductRepository;
import ucuenca.ejemplo.serviceproduct.service.ProductService;
import ucuenca.ejemplo.serviceproduct.service.ProductServiceImplement;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImplement(productRepository);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Categoria.builder().id(1L).build())
                .precio(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
    }

    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }
}
