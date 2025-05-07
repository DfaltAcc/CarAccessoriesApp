package za.ac.cput.domain;

public class Admin extends User{

 private String adminID;


 private Admin(AdminBuilder builder) {
  ;
  this.adminID = builder.adminID;
 }

 public String getAdminID() {
  return adminID;
 }

 @Override
 public String toString() {
  return "Admin{" +
          "adminID='" + adminID + '\'' +
          '}';
 }
 public static class AdminBuilder extends User.UserBuilder{
  private String adminID;

  public AdminBuilder setAdminID(String adminID){
   this.adminID = adminID;
   return this;
  }
  public AdminBuilder copy(Admin admin){
 super.copy(admin);
   admin.adminID = adminID;
   return this;
  }

  public Admin build(){
   return new Admin(this);
  }
 }
}
