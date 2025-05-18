package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Payment;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    private Payment payment1;
    private Payment payment2;
    private Payment payment3;

    @Test
    void testCreatePayment_Success() {
        payment1 = PaymentFactory.createPayment(
                "P001",
                LocalDate.of(2024, 7, 20),
                "Credit Card",
                250.75,
                "Completed"
        );
        assertNotNull(payment1);
        assertEquals("P001", payment1.getPaymentID());
        assertEquals(LocalDate.of(2024, 7, 20), payment1.getPaymentDate());
        System.out.println(payment1);
    }

    @Test
    void testCreatePayment_AutoGenerateID_Success() {
        payment2 = PaymentFactory.createPayment(
                LocalDate.now(),
                "EFT",
                1500.00,
                "Pending"
        );
        assertNotNull(payment2);
        assertNotNull(payment2.getPaymentID());
        assertTrue(payment2.getPaymentID().length() > 0);
        System.out.println(payment2);
    }


    @Test
    void testCreatePayment_Fail_NullPaymentID() {
        Payment paymentFail = PaymentFactory.createPayment(
                null,
                LocalDate.of(2024, 8, 15),
                "PayPal",
                99.99,
                "Processing"
        );
        assertNull(paymentFail);
        System.out.println("Test with null paymentID: " + null);
    }

    @Test
    void testCreatePayment_Fail_EmptyPaymentMethod() {
        Payment paymentFail = PaymentFactory.createPayment(
                "P002",
                LocalDate.of(2024, 8, 15),
                "",
                99.99,
                "Processing"
        );
        assertNull(paymentFail);
        System.out.println("Test with empty payment method: " + null);
    }

    @Test
    void testCreatePayment_Fail_InvalidAmount() {
        Payment paymentFail = PaymentFactory.createPayment(
                "P003",
                LocalDate.of(2024, 9, 1),
                "Cash",
                -50.00,
                "Completed"
        );
        assertNull(paymentFail);
        System.out.println("Test with negative amount: " + null);
    }

    @Test
    void testCreatePayment_Fail_NullDate() {
        Payment paymentFail = PaymentFactory.createPayment(
                "P004",
                null,
                "Debit Card",
                120.00,
                "Completed"
        );
        assertNull(paymentFail);
        System.out.println("Test with null date: " + null);
    }


    @Test
    void testPaymentEquality() {
        payment1 = PaymentFactory.createPayment(
                "EQ001",
                LocalDate.of(2025, 1, 10),
                "Credit Card",
                100.00,
                "Success"
        );
        payment2 = PaymentFactory.createPayment(
                "EQ001",
                LocalDate.of(2025, 1, 10),
                "Credit Card",
                100.00,
                "Success"
        );
        payment3 = PaymentFactory.createPayment(
                "EQ002",
                LocalDate.of(2025, 1, 10),
                "Credit Card",
                100.00,
                "Success"
        );

        assertNotNull(payment1);
        assertNotNull(payment2);
        assertNotNull(payment3);

        assertEquals(payment1, payment2);
        System.out.println("Payment1: " + payment1);
        System.out.println("Payment2: " + payment2);

        assertNotEquals(payment1, payment3);
        System.out.println("Payment3: " + payment3);
    }

    @Test
    void testPaymentIdentity() {
        payment1 = PaymentFactory.createPayment(
                "ID001",
                LocalDate.of(2025, 2, 15),
                "EFT",
                200.00,
                "Pending"
        );
        payment2 = PaymentFactory.createPayment(
                "ID001",
                LocalDate.of(2025, 2, 15),
                "EFT",
                200.00,
                "Pending"
        );
        payment3 = payment1;

        assertNotNull(payment1);
        assertNotNull(payment2);

        assertSame(payment1, payment3);
        assertNotSame(payment1, payment2);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testCreatePayment_Performance() {
        payment1 = PaymentFactory.createPayment(
                "PERF001",
                LocalDate.now(),
                "Bitcoin",
                0.005,
                "Confirmed"
        );
        assertNotNull(payment1);
    }

    @Test
    @Disabled("This test is currently disabled as an example")
    void testDisabledExample() {
        fail("This test should have been disabled.");
    }
}