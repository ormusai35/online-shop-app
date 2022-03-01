package serverapp.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import serverapp.onlineshop.model.CartLine;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long>{

}
