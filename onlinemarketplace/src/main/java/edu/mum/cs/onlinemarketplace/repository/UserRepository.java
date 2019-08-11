package edu.mum.cs.onlinemarketplace.repository;
import edu.mum.cs.onlinemarketplace.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
