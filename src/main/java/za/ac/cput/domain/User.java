package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    protected String userID;
    
    @Column(nullable = false)
    protected String name;
    
    @Column(nullable = false)
    protected String password;
    
    protected String address;
    
    @Column(name = "phone_number")
    protected String phoneNumber;
    
    @Column(nullable = false)
    protected String role;
    
    @Column(unique = true, nullable = false)
    protected String email;
}