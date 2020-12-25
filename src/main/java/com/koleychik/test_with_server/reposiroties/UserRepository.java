package com.koleychik.test_with_server.reposiroties;

import com.koleychik.test_with_server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("DELETE User u WHERE u.id =  ")
    void deleteById(long id);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(String name);

    @Query("SELECT u FROM User u ORDER BY u.age")
    List<User> findAllOrderedByFirstName();
}
