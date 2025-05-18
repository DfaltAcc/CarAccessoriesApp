package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper; // Ensure this class and its methods are correctly defined

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentID, LocalDate paymentDate, String paymentMethod,
                                        double amount, String status) {

        // Validate inputs using Helper methods
        // Ensure Helper methods are robust (e.g., isNullOrInvalidDate handles null LocalDate)
        if (Helper.isNullOrEmpty(paymentID) ||
                (paymentDate != null && Helper.isNullOrInvalidDate(paymentDate)) || // Check for null before validating date if it can be null
                Helper.isNullOrEmpty(paymentMethod) ||
                Helper.isNegativeOrZero(amount) || // Assuming this checks if amount <= 0
                Helper.isNullOrEmpty(status)) {
            return null; // Or throw an IllegalArgumentException
        }

        // If paymentDate can be null, and Helper.isNullOrInvalidDate doesn't handle null:
        // if (paymentDate == null) {
        //     // Handle case where paymentDate is allowed to be null or throw exception
        // } else if (Helper.isNullOrInvalidDate(paymentDate)) {
        //     return null;
        // }


        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentDate(paymentDate) // Now correctly passes LocalDate
                .setPaymentMethod(paymentMethod)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }

    public static Payment createPayment(LocalDate paymentDate, String paymentMethod,
                                        double amount, String status) {

        String paymentID = Helper.generateId(); // Ensure this generates a valid, non-null ID

        // Validate inputs
        if ((paymentDate != null && Helper.isNullOrInvalidDate(paymentDate)) ||
                Helper.isNullOrEmpty(paymentMethod) ||
                Helper.isNegativeOrZero(amount) ||
                Helper.isNullOrEmpty(status)) {
            return null; // Or throw an IllegalArgumentException
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentDate(paymentDate) // Correctly passes LocalDate
                .setPaymentMethod(paymentMethod)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }
}