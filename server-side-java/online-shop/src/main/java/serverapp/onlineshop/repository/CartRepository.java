package serverapp.onlineshop.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
	
//	@Query("from Cart c where c.user_id = :id")
//	List<Cart> findByUserId(@Param("id") long id);

	Cart findByCartId(long id);
	
	Collection<Cart> findByUser(User user);
	
	Collection<Cart> findByTotal(double totalPrice);
	
	@Query(value = "SELECT * FROM Cart u WHERE u.user_id = 1",nativeQuery = true)
	Collection<Cart> findAllCartsByUser();
	
	
	
}
