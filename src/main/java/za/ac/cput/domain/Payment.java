/* Payment.java

     Payment POJO class

     Author: Hlumelo Madlingozi (222648120)

     Date: 11 May 2025 */

package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Payment {

    private final String paymentID;
    private final LocalDate paymentDate;
    private final String paymentMethod;
    private final double amount;
    private final String status;

    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.amount = builder.amount;
        this.status = builder.status;
    }

    public static Object builder() {
        return null;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 &&
                Objects.equals(paymentID, payment.paymentID) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(paymentMethod, payment.paymentMethod) &&
                Objects.equals(status, payment.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, paymentDate, paymentMethod, amount, status);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentID;
        private LocalDate paymentDate;
        private String paymentMethod;
        private double amount;
        private String status;

        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentID = payment.paymentID;
            this.paymentDate = payment.paymentDate;
            this.paymentMethod = payment.paymentMethod;
            this.amount = payment.amount;
            this.status = payment.status;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
