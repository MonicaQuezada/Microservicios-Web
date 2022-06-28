package ucuenca.ejemplo.serviceproduct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categories")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
