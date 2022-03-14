package com.buythebookstore.dataAccess;

import com.buythebookstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
}
