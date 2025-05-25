package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Table(name = "payments")


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Payment {

    @Id
    @EqualsAndHashCode.Include

    private String paymentId;

    private LocalDate paymentDate;
    private String paymentMethod;
    private double amount;
    private String status;

    private Payment(ManualBuilder manualBuilder) {
        this.paymentId = manualBuilder.paymentId; // Use consistent field name
        this.paymentDate = manualBuilder.paymentDate;
        this.paymentMethod = manualBuilder.paymentMethod;
        this.amount = manualBuilder.amount;
        this.status = manualBuilder.status;
    }

    public static ManualBuilder manualBuilder() {
        return new ManualBuilder();
    }

    public static class ManualBuilder {
        private String paymentId;
        private LocalDate paymentDate;
        private String paymentMethod;
        private double amount;
        private String status;

        public ManualBuilder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public ManualBuilder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public ManualBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public ManualBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public ManualBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public ManualBuilder copy(Payment payment) {
            this.paymentId = payment.paymentId; // Use consistent field name
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