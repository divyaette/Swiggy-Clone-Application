package org.demoproject.swiggyclone.service;

import jakarta.transaction.Transactional;
import org.demoproject.swiggyclone.entity.User;
import org.demoproject.swiggyclone.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
   }
   @Transactional
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }
   @Transactional
   public User getUserById(int userId) {
       return userRepository.findById(userId).get();
   }
   @Transactional
  public User createUser(User user) {
       return userRepository.save(user);
  }
  @Transactional
  public void deleteById(int userId) {
       userRepository.deleteById(userId);
  }
  @Transactional
  public User updateUser(User user) {
       return userRepository.save(user);
  }
  @Transactional
  public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
