/* Payment.java

     Payment POJO class

     Author: Hlumelo Madlingozi (222648120)

     Date: 11 May 2025 */

package za.ac.cput.domain;
import java.util.Date;

public class Payment {
    private String paymentID;
    private Date paymentDate;
    private String paymentMethod;
    private double amount;
    private String status;


    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.amount = builder.amount;
        this.status = builder.status;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public Date getPaymentDate() {
        return paymentDate != null ? new Date(paymentDate.getTime()) : null;
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

    public static class Builder {
        private String paymentID;
        private Date paymentDate;
        private String paymentMethod;
        private double amount;
        private String status;

        public Builder() {
        }

        public Builder paymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder paymentDate(Date paymentDate) {
            this.paymentDate = paymentDate != null ? new Date(paymentDate.getTime()) : null;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Payment build() {
            if (paymentID == null || paymentID.isEmpty()) {
                throw new IllegalStateException("Payment ID cannot be null or empty");
            }
            if (paymentDate == null) {
                throw new IllegalStateException("Payment Date cannot be null");
            }
            return new Payment(this);
        }
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
    }}

