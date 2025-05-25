/* PaymentFactory.java

     Payment POJO class

     Author: Hlumelo Madlingozi (222648120)

     Date: 18 May 2025 */


package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentID, LocalDate paymentDate, String paymentMethod,
                                        double amount, String status) {

        if (Helper.isNullOrEmpty(paymentID) ||
                (paymentDate != null && Helper.isNullOrInvalidDate(paymentDate)) || // Check for null before validating date if it can be null
                Helper.isNullOrEmpty(paymentMethod) ||
                Helper.isNegativeOrZero(amount) ||
                Helper.isNullOrEmpty(status)) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(paymentMethod)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }

    public static Payment createPayment(LocalDate paymentDate, String paymentMethod,
                                        double amount, String status) {

        String paymentID = Helper.generateId();

        if ((paymentDate != null && Helper.isNullOrInvalidDate(paymentDate)) ||
                Helper.isNullOrEmpty(paymentMethod) ||
                Helper.isNegativeOrZero(amount) ||
                Helper.isNullOrEmpty(status)) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(paymentMethod)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }
}