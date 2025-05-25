package za.ac.cput.service;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.Optional;

public interface IAdminService extends IService<Admin,String>{
    Admin findByName(String name);

//    Optional<Admin> findByPhoneNumber(String PhoneNumber);

    Optional<Admin> findByEmail(String email);

    List<Admin> findAllByUserID(String userID);

}
