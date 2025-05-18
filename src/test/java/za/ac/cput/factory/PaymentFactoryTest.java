/* PaymentFactoryTest.java

     Payment POJO class

     Author: Hlumelo Madlingozi (222648120)

     Date: 18 May 2025 */


package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    private String validPaymentID;
    private LocalDate validPaymentDate;
    private String validPaymentMethod;
    private double validAmount;
    private String validStatus;

    @BeforeEach
    void setUp() {
        validPaymentID = "P12345";
        validPaymentDate = LocalDate.of(2024, 8, 15);
        validPaymentMethod = "Credit Card";
        validAmount = 250.75;
        validStatus = "Completed";
    }

    @Test
    @DisplayName("Test successful Payment creation with explicit ID")
    void testCreatePayment_withValidData_explicitID() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, validPaymentMethod, validAmount, validStatus);
        assertNotNull(payment, "Payment object should not be null for valid data.");
        assertEquals(validPaymentID, payment.getPaymentID());
        assertEquals(validPaymentDate, payment.getPaymentDate());
        assertEquals(validPaymentMethod, payment.getPaymentMethod());
        assertEquals(validAmount, payment.getAmount());
        assertEquals(validStatus, payment.getStatus());
    }

    @Test
    @DisplayName("Test Payment creation with null paymentID")
    void testCreatePayment_withNullPaymentID() {
        Payment payment = PaymentFactory.createPayment(null, validPaymentDate, validPaymentMethod, validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentID is null.");
    }

    @Test
    @DisplayName("Test Payment creation with empty paymentID")
    void testCreatePayment_withEmptyPaymentID() {
        Payment payment = PaymentFactory.createPayment("", validPaymentDate, validPaymentMethod, validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentID is empty.");
    }

    @Test
    @DisplayName("Test Payment creation with null paymentDate")
    void testCreatePayment_withNullPaymentDate() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, null, validPaymentMethod, validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentDate is null.");
    }

    @Test
    @DisplayName("Test Payment creation with null paymentMethod")
    void testCreatePayment_withNullPaymentMethod() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, null, validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentMethod is null.");
    }

    @Test
    @DisplayName("Test Payment creation with empty paymentMethod")
    void testCreatePayment_withEmptyPaymentMethod() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, "", validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentMethod is empty.");
    }

    @Test
    @DisplayName("Test Payment creation with zero amount")
    void testCreatePayment_withZeroAmount() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, validPaymentMethod, 0.0, validStatus);
        assertNull(payment, "Payment should be null if amount is zero.");
    }

    @Test
    @DisplayName("Test Payment creation with negative amount")
    void testCreatePayment_withNegativeAmount() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, validPaymentMethod, -10.0, validStatus);
        assertNull(payment, "Payment should be null if amount is negative.");
    }

    @Test
    @DisplayName("Test Payment creation with null status")
    void testCreatePayment_withNullStatus() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, validPaymentMethod, validAmount, null);
        assertNull(payment, "Payment should be null if status is null.");
    }

    @Test
    @DisplayName("Test Payment creation with empty status")
    void testCreatePayment_withEmptyStatus() {
        Payment payment = PaymentFactory.createPayment(validPaymentID, validPaymentDate, validPaymentMethod, validAmount, "");
        assertNull(payment, "Payment should be null if status is empty.");
    }

    @Test
    @DisplayName("Test successful Payment creation with generated ID")
    void testCreatePayment_withValidData_generatedID() {
        Payment payment = PaymentFactory.createPayment(validPaymentDate, validPaymentMethod, validAmount, validStatus);
        assertNotNull(payment, "Payment object should not be null for valid data.");
        assertNotNull(payment.getPaymentID(), "Generated paymentID should not be null.");
        assertFalse(payment.getPaymentID().isEmpty(), "Generated paymentID should not be empty.");
        assertEquals(validPaymentDate, payment.getPaymentDate());
        assertEquals(validPaymentMethod, payment.getPaymentMethod());
        assertEquals(validAmount, payment.getAmount());
        assertEquals(validStatus, payment.getStatus());
    }

    @Test
    @DisplayName("Test Payment creation (generated ID) with null paymentDate")
    void testCreatePayment_generatedID_withNullPaymentDate() {
        Payment payment = PaymentFactory.createPayment(null, validPaymentMethod, validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentDate is null (generated ID).");
    }

    @Test
    @DisplayName("Test Payment creation (generated ID) with empty paymentMethod")
    void testCreatePayment_generatedID_withEmptyPaymentMethod() {
        Payment payment = PaymentFactory.createPayment(validPaymentDate, "", validAmount, validStatus);
        assertNull(payment, "Payment should be null if paymentMethod is empty (generated ID).");
    }

    @Test
    @DisplayName("Test Payment creation (generated ID) with negative amount")
    void testCreatePayment_generatedID_withNegativeAmount() {
        Payment payment = PaymentFactory.createPayment(validPaymentDate, validPaymentMethod, -50.0, validStatus);
        assertNull(payment, "Payment should be null if amount is negative (generated ID).");
    }

    @Test
    @DisplayName("Test Payment creation (generated ID) with empty status")
    void testCreatePayment_generatedID_withEmptyStatus() {
        Payment payment = PaymentFactory.createPayment(validPaymentDate, validPaymentMethod, validAmount, "");
        assertNull(payment, "Payment should be null if status is empty (generated ID).");
    }

    @Test
    @Disabled("Enable if you want to specifically test the ID generation via the factory")
    @DisplayName("Test generated ID uniqueness (conceptual)")
    void testGeneratedIdUniqueness() {
        Payment payment1 = PaymentFactory.createPayment(validPaymentDate, validPaymentMethod, validAmount, validStatus);
        Payment payment2 = PaymentFactory.createPayment(validPaymentDate, validPaymentMethod, validAmount, validStatus);

        assertNotNull(payment1);
        assertNotNull(payment2);
        assertNotNull(payment1.getPaymentID());
        assertNotNull(payment2.getPaymentID());
        assertNotEquals(payment1.getPaymentID(), payment2.getPaymentID(), "Generated IDs should be unique.");
    }
}