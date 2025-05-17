package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin createAdmin(String address, String adminID,String password,
                                    String name,String phoneNumber,String email,
                                    String role, String userID) {
        if(Helper.isNullOrEmpty(name)
                ||Helper.isNullOrEmpty(address)
                ||Helper.isNullOrEmpty(adminID)
                ||Helper.isNullOrEmpty(phoneNumber)
                ||Helper.isNullOrEmpty(role)
                ||Helper.isNullOrEmpty(userID))
            return null;

if(!Helper.validateEmail(email)){
    return null;
}
if(!Helper.validatePassword(password).isValid()){
    return null;

}

        return new Admin.Builder()
                .setAdminID(adminID)
                .setAddress(address)
                .setUserID(userID)
                .setPassword(password)
                .setEmail(email)
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setRole(role)
                .build();

    }
}
