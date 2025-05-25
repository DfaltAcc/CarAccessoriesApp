package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {

 private String adminID;


 private Admin(Builder builder) {
  super(builder.userID, builder.password,
          builder.name, builder.address,
          builder.phoneNumber, builder.role,
          builder.email);
  this.adminID = builder.adminID;
 }

 public Admin() {

 }

 public String getAdminID() {
  return adminID;
 }

 @Override
 public String toString() {
  return "Admin{" +
          "adminID='" + adminID + '\'' +
          ", address='" + address + '\'' +
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
  private String userID;


  public Builder setAddress(String address) {
   this.address = address;
   return this;
  }

  public Builder setAdminID(String adminID) {
   this.adminID = adminID;
   return this;
  }

  public Builder setEmail(String email) {
   this.email = email;
   return this;
  }

  public Builder setName(String name) {
   this.name = name;
   return this;
  }

  public Builder setPassword(String password) {
   this.password = password;
   return this;
  }

  public Builder setPhoneNumber(String phoneNumber) {
   this.phoneNumber = phoneNumber;
   return this;
  }

  public Builder setRole(String role) {
   this.role = role;
   return this;
  }

  public Builder setUserID(String userID) {
   this.userID = userID;
   return this;
  }

  public Builder copy(Admin admin) {
   this.adminID = admin.adminID;
   this.password = admin.password;
   this.name = admin.name;
   this.address = admin.address;
   this.phoneNumber = admin.phoneNumber;
   this.role = admin.role;
   this.email = admin.email;
   this.userID = admin.userID;
   return this;
  }
  public Admin build() {
   return new Admin(this);
  }
 }
}