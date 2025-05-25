package za.ac.cput.service; // Adjust package based on your PaymentServiceImpl location

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
// Import the specific Payment Service interface

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// This annotation loads the Spring Boot application context for testing
// It's needed to inject the service under test and the mocked repository
@SpringBootTest
class PaymentServiceTest {

    // Inject the service implementation that we want to test.
    // Spring Boot Test will find the PaymentServiceImpl bean and inject it.
    @Autowired
    private IPaymentService paymentService; // Inject the interface, Spring provides the implementation

    // Mock the repository dependency.
    // @MockBean adds a mock of PaymentRepository to the Spring context,
    // which will be injected into the PaymentServiceImpl by @Autowired.
    @MockBean
    private PaymentRepository paymentRepository;

    // Sample Payment objects for testing
    private Payment payment1;
    private Payment payment2;

    @BeforeEach // This method runs before each test method
    void setUp() {
        // Initialize sample payments using the Builder pattern (assuming Lombok)
        // Adjust initialization based on your domain class constructors/setters if not using Lombok
        payment1 = Payment.builder()
                .paymentId("P001")
                .paymentDate(LocalDate.of(2024, 5, 23))
                .paymentMethod("Credit Card")
                .amount(2500.75)
                .status("Completed")
                .build();

        payment2 = Payment.builder()
                .paymentId("P002")
                .paymentDate(LocalDate.of(2024, 5, 24))
                .paymentMethod("EFT")
                .amount(800.00)
                .status("Pending")
                .build();
    }

    @Test
    void testCreate() {
        Mockito.when(paymentRepository.save(payment1)).thenReturn(payment1);


        Payment createdPayment = paymentService.create(payment1);
        Assertions.assertNotNull(createdPayment);
        Assertions.assertEquals(payment1, createdPayment);

        Mockito.verify(paymentRepository, Mockito.times(1)).save(payment1);
    }

    @Test
    void testRead_Found() {

        Mockito.when(paymentRepository.findById("P001")).thenReturn(Optional.of(payment1));


        Payment foundPayment = paymentService.read("P001");


        Assertions.assertNotNull(foundPayment);
        Assertions.assertEquals(payment1, foundPayment);


        Mockito.verify(paymentRepository, Mockito.times(1)).findById("P001");
    }

    @Test
    void testRead_NotFound() {

        Mockito.when(paymentRepository.findById("NonExistentID")).thenReturn(Optional.empty());
        Payment notFoundPayment = paymentService.read("NonExistentID");
        Assertions.assertNull(notFoundPayment);
        Mockito.verify(paymentRepository, Mockito.times(1)).findById("NonExistentID");
    }

    @Test
    void testUpdate() {
        Payment updatedPaymentDetails = Payment.builder()
                .paymentId("P001")
                .paymentDate(LocalDate.of(2024, 5, 23))
                .paymentMethod("Online Banking")
                .amount(2600.00)
                .status("Processed")
                .build();

        Mockito.when(paymentRepository.save(updatedPaymentDetails)).thenReturn(updatedPaymentDetails);

        // Act: Call the service method under test
        Payment resultPayment = paymentService.update(updatedPaymentDetails);

        // Assert: Verify the result and that the repository method was called
        Assertions.assertNotNull(resultPayment);
        Assertions.assertEquals("Online Banking", resultPayment.getPaymentMethod()); // Check if the update was applied
        Assertions.assertEquals(2600.00, resultPayment.getAmount());

        // Verify: Ensure the mocked repository's save method was called correctly
        Mockito.verify(paymentRepository, Mockito.times(1)).save(updatedPaymentDetails);
    }

    @Test
    void testDelete_Existing() {
        // Arrange: Mock the repository's behavior for deletion
        // When existsById("P001") is called, return true (means the payment exists)
        Mockito.when(paymentRepository.existsById("P001")).thenReturn(true);
        // When deleteById("P001") is called, do nothing (because it's a void method)
        Mockito.doNothing().when(paymentRepository).deleteById("P001");

        // Act: Call the service method under test
        boolean deleted = paymentService.delete("P001");

        // Assert: Verify the result is true (deletion was attempted for an existing ID)
        Assertions.assertTrue(deleted);

        // Verify: Ensure the mocked repository methods were called correctly
        // Verify that existsById was called exactly once with "P001"
        Mockito.verify(paymentRepository, Mockito.times(1)).existsById("P001");
        // Verify that deleteById was called exactly once with "P001"
        Mockito.verify(paymentRepository, Mockito.times(1)).deleteById("P001");
    }

    @Test
    void testDelete_NonExistent() {
        // Arrange: Mock the repository's behavior for a non-existent ID
        // When existsById("NonExistentID") is called, return false (means the payment does not exist)
        Mockito.when(paymentRepository.existsById("NonExistentID")).thenReturn(false);
        // We don't need to mock deleteById here as it should not be called by the service

        // Act: Call the service method under test
        boolean deleted = paymentService.delete("NonExistentID");

        // Assert: Verify the result is false (deletion failed because the ID didn't exist)
        Assertions.assertFalse(deleted);

        // Verify: Ensure the mocked repository methods were called correctly
        // Verify that existsById was called exactly once with "NonExistentID"
        Mockito.verify(paymentRepository, Mockito.times(1)).existsById("NonExistentID");
        // Verify that deleteById was NOT called with any string
        Mockito.verify(paymentRepository, Mockito.never()).deleteById(Mockito.anyString());
    }

    @Test
    void testGetAll() {
        // Arrange: Create a list of sample payments
        List<Payment> paymentList = Arrays.asList(payment1, payment2);

        // Arrange: Mock the repository's findAll method to return this list
        Mockito.when(paymentRepository.findAll()).thenReturn(paymentList);

        // Act: Call the service method under test
        List<Payment> resultList = paymentService.getAll();

        // Assert: Verify the result and that the repository method was called
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(2, resultList.size()); // Check the size of the returned list
        Assertions.assertTrue(resultList.contains(payment1)); // Check if the list contains the sample payments
        Assertions.assertTrue(resultList.contains(payment2));

        // Verify: Ensure the mocked repository's findAll method was called correctly
        Mockito.verify(paymentRepository, Mockito.times(1)).findAll();
    }

    // Add more tests for any custom methods you add to IPaymentService
}