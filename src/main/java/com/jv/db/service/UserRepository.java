package com.jv.db.service;

import com.jv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from users u where LOWER(u.lastname) = LOWER(:lastname)")
    List<User> find(@Param("lastname")String lastname);

}
