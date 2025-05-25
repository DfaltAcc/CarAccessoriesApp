package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> read(String userID) {
        return userRepository.findById(userID);
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getUserID())) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllByUserID(String userID) {
        return userRepository.findAllByUserID(userID); // Still questionable
    }
}
