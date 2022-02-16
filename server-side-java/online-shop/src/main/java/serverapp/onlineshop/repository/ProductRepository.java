package serverapp.onlineshop.repository;

import org.springframework.stereotype.Repository;
import serverapp.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
}
