package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AdminFactoryTest {

        private static Admin admin  = AdminFactory.createAdmin("12L",
                "001L","lee433$","Lee",
                "333455","leee@k","Customer","lee05");

        @Test
        void createAdmin() {
            assertNotNull(admin.getAdminID());
            assertEquals("12L",admin.getAddress());
            assertEquals("001L",admin.getAdminID());
            assertEquals("lee433$",admin.getPassword());
            assertEquals("Lee",admin.getName());
            assertEquals("leee@k",admin.getEmail());

            assertEquals("333455",admin.getPhoneNumber());
            assertEquals("Customer",admin.getRole());
            assertEquals("lee05",admin.getUserID());

            System.out.println(admin);
        }
}
