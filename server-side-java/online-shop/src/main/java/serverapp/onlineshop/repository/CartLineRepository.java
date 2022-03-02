package serverapp.onlineshop.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.CartLine;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long>{
	
	@Query(value = "SELECT * FROM CART_LINE u WHERE u.cart_id = ?1",nativeQuery = true)
	List<CartLine> findCartLineByCartId(long cartId);

}
