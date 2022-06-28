package ucuenca.ejemplo.serviceshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucuenca.ejemplo.serviceshopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
