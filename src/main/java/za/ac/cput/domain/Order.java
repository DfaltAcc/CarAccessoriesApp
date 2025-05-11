package za.ac.cput.domain;

//Pojo class
//Kholiwe Faith Mafenuka
//221686584

import java.time.LocalDate;

public class Order {

        private String orderId;

        private LocalDate orderDate;

        private double totalAmount;

        private String status;


    public Order(){

    }

        public Order(Builder builder) {
            this.orderId = builder.orderId;
            this.orderDate = builder.orderDate;
            this.status = builder.status;
            this.totalAmount = builder.totalAmount;
        }

    public String getOrderId() {
        return orderId;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {

        private String orderId;
        private LocalDate orderDate;
        private double totalAmount;
        private String status;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.getOrderId();
            this.orderDate = order.getOrderDate();
            this.totalAmount = order.getTotalAmount();
            this.status = order.getStatus();
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }

}


