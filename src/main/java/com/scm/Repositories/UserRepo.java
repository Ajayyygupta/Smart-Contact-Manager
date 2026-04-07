package com.scm.Repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.Users;
import com.scm.form.UserForm;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<Users, String>{

    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email, String password);








}
