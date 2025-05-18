package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User createUser(String address, String password,
                                  String name, String phoneNumber, String email,
                                  String role, String userID) {
        if (Helper.isNullOrEmpty(name)
                || Helper.isNullOrEmpty(address)
                || Helper.isNullOrEmpty(phoneNumber)
                || Helper.isNullOrEmpty(role)
                || Helper.isNullOrEmpty(userID))
            return null;

        if (Helper.isValidEmail(email)) {
            return null;
        }
        if (Helper.isNullOrEmpty(password)) {
            return null;
        }

        return new User.Builder()
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
