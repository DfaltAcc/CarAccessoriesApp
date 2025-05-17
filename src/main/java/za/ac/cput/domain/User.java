package za.ac.cput.domain;

public class User {
    protected String userID;
    protected String name;
    protected String password;
    protected String address;
    protected String phoneNumber;
    protected String role;
    protected String email;

    protected User(String userID, String password, String name, String address, String phoneNumber, String role, String email) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.email = email;
    }

    public User(Builder builder) {
        this.userID = builder.userID;
        this.name = builder.name;
        this.password = builder.password;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.email = builder.email;
    }

protected User(){}

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder{
        private String userID;
        private String name;
        private String password;
        private String address;
        private String phoneNumber;
        private String role;
        private String email;

        public Builder setAddress(String address) {
            this.address = address;
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
        public Builder copy(Builder builder){
            this.address=builder.address;
            this.name=builder.name;
            this.userID=builder.userID;
            this.email= builder.email;
            this.password=builder.password;
            this.role=builder.role;
            this.phoneNumber=builder.phoneNumber;
            return this;
        }
        public User Build(){
            return new User(this);
        }
    }

}
