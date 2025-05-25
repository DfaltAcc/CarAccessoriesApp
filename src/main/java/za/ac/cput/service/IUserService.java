package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IService<User,String>{
    User findByName(String name);

    Optional<User> findByPhoneNumber(String PhoneNumber);

    Optional<User> findByEmail(String email);

    List<User> findAllByUserID(String userID);

}
