package edu.mum.cs.onlinemarketplace.repository;

import edu.mum.cs.onlinemarketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.type='SELLER'")
    public List<User>getAllSeller();

    @Query("select u from User u where u.type ='SELLER' and u.id=:id")
    public User getUserBySellerId(Long id);

    @Query("delete from User u where u.type='SELLER' and u.id=:id")
    public User deleteSellerById(Long id);
}
