package com.scm.Service;

import java.util.List;
import java.util.Optional;

import com.scm.entities.Users;

public interface UserService {

    Users saveUser(Users user);

    Optional<Users> getUserById(String id);
    Optional<Users> updateUser(Users user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isUSerExistByEmail(String email);

    //for all User
    List<Users> getAllUsers();
 
}
