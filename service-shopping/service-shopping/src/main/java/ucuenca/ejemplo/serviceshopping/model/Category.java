package ucuenca.ejemplo.serviceshopping.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Category {

    private Long id;
    private String name;
}
