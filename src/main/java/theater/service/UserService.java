package theater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theater.model.User;
import theater.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getALl(){
        return userRepository.findAll();
    }

    public User getUser(String email){
        return userRepository.findById(email).get();
    }

    public User create(User user){
        userRepository.save(user);
        return user;
    }

    public User delete(String email){
        User record = userRepository.findById(email).get();
        userRepository.deleteById(email);
        return record;
    }
}
