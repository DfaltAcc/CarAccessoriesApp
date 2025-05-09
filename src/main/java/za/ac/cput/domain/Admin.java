package za.ac.cput.domain;

public class Admin extends User {
protected String adminID;

 public Admin(String userID, String password, String name, String address, String phoneNumber, String role, String email) {
  super(userID, password, name, address, phoneNumber, role, email);
 }

 public String getAdminID() {
  return adminID;
 }

 @Override
 public String toString() {
  return "Admin{" +
          "address='" + address + '\'' +
          ", email='" + email + '\'' +
          ", name='" + name + '\'' +
          ", password='" + password + '\'' +
          ", phoneNumber='" + phoneNumber + '\'' +
          ", role='" + role + '\'' +
          ", userID='" + userID + '\'' +
          '}';
 }
 public static class Builder {
  private String adminID;
  private String password;
  private String name;
  private String address;
  private String phoneNumber;
  private String role;
  private String email;



 }
}
