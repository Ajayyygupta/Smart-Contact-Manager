package com.scm.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Repositories.UserRepo;
import com.scm.Service.UserService;
import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //User id: dynamically generate karenge
         String userId =UUID.randomUUID().toString();
         user.setUserID(userId);
         return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
       User user2=userRepo.findById(user.getUserID()).orElseThrow(()-> new ResourceNotFoundException("User not found"));

       //User 2 me nayi imformation jo databse se aai hai, Isliye ab ham update karenge \
       //User 2 from User

       user2.setName(user.getName());
       user2.setEmail(user.getEmail());
       user2.setPassword(user.getPassword());
       user2.setAbout(user.getAbout());
       user2.setPhoneNumber(user.getPhoneNumber());
       user2.setProfilePic(user.getProfilePic());
       user2.setEnabled(user.isEmailVerified());
       user2.setPhoneVerified(user.isPhoneVerified());
       user2.setProvide(user.getProvide());
       user2.setProviderUserid(user.getProviderUserid());

       //save the user in databse

      User save= userRepo.save(user2);
      return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {

        User user2=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);
        
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2=userRepo.findById(userId).orElse(null);
        return user2!=null ? true : false;
       
    }

    @Override
    public boolean isUSerExistByEmail(String email) {
      User user= userRepo.findByEmail(email).orElse(null);
      return user!= null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    



}
