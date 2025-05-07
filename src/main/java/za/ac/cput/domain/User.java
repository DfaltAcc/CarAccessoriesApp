package za.ac.cput.domain;

public class User {
    private String userID;
    private String name;
    private String password;
    private String address;
    private String phoneNumber;
    private String role;
    private String email;

    public User(){

    }
    protected User(UserBuilder builder){
        this.userID = builder.userID;
        this.name = builder.name;
        this.password = builder.password;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.role = builder.role;
        this.email=builder.email;

    }

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
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String userID;
        private String name;
        private String password;
        private String address;
        private String phoneNumber;
        private String role;
        private String email;

        public UserBuilder setUserID(String userID) {
            this.userID = userID;
            return this;
        }
        public UserBuilder setName(String name) {
            this.name = name;
            return this;

        }
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        public UserBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public UserBuilder setRole(String role) {
            this.role = role;
            return this;
        }
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public  UserBuilder copy(User user){
            userID = user.userID;
            name = user.name;
            password = user.password;
            address = user.address;
            phoneNumber = user.phoneNumber;
            role = user.role;
            email = user.email;

            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
