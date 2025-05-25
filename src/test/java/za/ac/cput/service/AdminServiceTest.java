package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class AdminServiceTest {
@Autowired
private AdminService adminService;
 private Admin admin = AdminFactory.createAdmin("566A","002A","admin@23",
         "Lebo","6654332","Lebo@gmail.com","Admin","004L");


      @Test
      @Order(1)
      void a_create() {
         Admin created =adminService.save(admin);
         assertNotNull(created);
         System.out.println(created);

      }

      @Test
      @Order(2)
      void b_read() {

         Admin read = adminService.findByName(admin.getName());
         assertNotNull(read);

         System.out.println(read);
      }

      @Test
      @Order(3)
      void c_update() {
         Admin newAdmin = new Admin.Builder().copy(admin).setAdminID("77y").build();
         Admin upudate = adminService.save(newAdmin);
         assertNotNull(upudate);
         System.out.println(upudate);

      }

      @Test
      @Disabled
      @Order(4)
      void delete() {
         Admin saved = adminService.save(admin);
         assertNotNull(saved);


      }
   }