package za.ac.cput.factory;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserFactoryTest {
    private User user1=UserFactory.createUser("yalon","gray05","Kman","77777"
            ,"yalon2gmail.com","Admin","n001");
    @Test
    void testCreateUser() {
        assertNotNull(user1);
        assertEquals("yalon",user1.getAddress());
        assertEquals("gray05",user1.getPassword());
        assertEquals("yalon2gmail.com",user1.getEmail());
        assertEquals("Kman",user1.getName());
        assertEquals("77777",user1.getPhoneNumber());
        assertEquals("Admin",user1.getRole());
        assertEquals("n001",user1.getUserID());

    }

//    @Test
//    void testCreateCustomerShouldReturnNullWhenEmailIsNull() {
//        Customer c = CustomerFactory.createCustomer(
//                "yalon", "gray", null, "77777",
//                "gv trio", "34E", "namcity", "gp", "phb", "SA", 88
//        );
//    }
}