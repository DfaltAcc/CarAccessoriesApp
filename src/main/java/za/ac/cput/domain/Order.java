package za.ac.cput.domain;

//Pojo class
//Kholiwe Faith Mafenuka
//221686584

import java.util.Date;

public class Order {

        private String orderId;

        private Date orderDate;

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

    public Date getOrderDate() {
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
        private Date orderDate;
        private double totalAmount;
        private String status;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        public Builder setOrderDate(Date orderDate) {
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

//To be added in future to merge the whole project

/* // Associations
       /* private User user; // The customer who placed the order
        private List<OrderItem> orderItems;
        private List<Payment> payments;
        public void addOrderItem(OrderItem item) {

            orderItems.add(item);
            recalculateTotalAmount();
        }

        private void recalculateTotalAmount() {
            totalAmount = orderItems.stream()
                    .mapToDouble(OrderItem::getSubtotal)
                    .sum();
        }

        public void addPayment(Payment payment) {
            payments.add(payment);
        }
        */
