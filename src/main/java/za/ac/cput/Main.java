/* Main.java

     Payment POJO class

     Author: Hlumelo Madlingozi (222648120)

     Date: 18 May 2025 */


package za.ac.cput;


import za.ac.cput.domain.Payment;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Payment payment1 = new Payment.Builder()
                .setPaymentID("P001")
                .setPaymentDate(LocalDate.now())
                .setPaymentMethod("Credit Card")
                .setAmount(199.99)
                .setStatus("Completed")
                .build();

        System.out.println("Payment 1: " + payment1);

        Payment payment2 = new Payment.Builder()
                .setPaymentID("P002")
                .setAmount(50.00)
                .setPaymentMethod("EFT")
                .build();
        System.out.println("Payment 2: " + payment2);

        Payment payment3 = new Payment.Builder()
                .copy(payment1)
                .setPaymentID("P003")
                .setStatus("Pending")
                .build();
        System.out.println("Payment 3: " + payment3);
    }
}