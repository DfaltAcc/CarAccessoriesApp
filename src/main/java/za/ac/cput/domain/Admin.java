package za.ac.cput.domain;

public class Admin extends User {
protected String adminID;

 public Admin(String userID, String password, String name, String address, String phoneNumber, String role, String email) {
  super(userID, password, name, address, phoneNumber, role, email);
 }

 public String getAdminID() {
  return adminID;
 }

}
