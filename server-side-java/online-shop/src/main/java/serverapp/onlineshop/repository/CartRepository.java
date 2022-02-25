package serverapp.onlineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import serverapp.onlineshop.model.Cart;
import serverapp.onlineshop.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
	
	@Query("from Cart c where c.user_id = :id")
	List<Cart> findByUserId(@Param("id") long id);

	Cart findByCartId(long id);
	
}
