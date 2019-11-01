package es.unizar.murcy.service;

import es.unizar.murcy.model.User;
import es.unizar.murcy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User u) {
        return userRepository.save(u);
    }

    public User updateUser(User u) {
        return userRepository.save(u);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User create(User user) {
        return userRepository.save(user);
    }
}