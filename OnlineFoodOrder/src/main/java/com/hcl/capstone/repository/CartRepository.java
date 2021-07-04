package com.hcl.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entity.Cart;
import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.entity.User;

@Repository("cartRepository")
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value="select * from cart where food_id=? and user_id=?", nativeQuery=true)
	Cart findByFoodIdAndUserId(Menu foodId, User user);

	@Query(value="select * from cart where user_id=?", nativeQuery=true)
	List<Cart> findCartByUserId(long userId);

	@Query(value="delete from cart where user_id=?", nativeQuery=true)
	public void removeFromCartByUserId(long userId);

}
