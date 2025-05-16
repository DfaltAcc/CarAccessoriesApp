package za.ac.cput.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Helper {

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    private static final String[] VALID_PAYMENT_METHODS = {"credit_card", "debit_card", "paypal", "bank_transfer"};

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean validateEmail(String email) {
        if (isNullOrEmpty(email)) {
            return false;
        }
        return EMAIL_REGEX.matcher(email).matches();
    }

    public static ValidationResult validatePassword(String password) {
        if (isNullOrEmpty(password)) {
            return new ValidationResult(false, "Password cannot be empty");
        }

        if (password.length() < 8) {
            return new ValidationResult(false, "Password must be at least 8 characters long");
        }

        if (!password.matches(".*[A-Z].*")) {
            return new ValidationResult(false, "Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            return new ValidationResult(false, "Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*[0-9].*")) {
            return new ValidationResult(false, "Password must contain at least one number");
        }

        if (!password.matches(".*[^A-Za-z0-9].*")) {
            return new ValidationResult(false, "Password must contain at least one special character");
        }

        return new ValidationResult(true, "Password is strong");
    }

    public static String generateId(String prefix) {
        long timestamp = new Date().getTime();
        int random = new Random().nextInt(10000);
        return prefix + "_" + timestamp + "_" + random;
    }

    public static double calculateSubtotal(int quantity, double price) {
        return quantity * price;
    }

    public static double calculateOrderTotal(List<OrderItem> orderItems) {
        double total = 0.0;
        for (OrderItem item : orderItems) {
            total += (item.getQuantity() * item.getPriceAtPurchase());
        }
        return total;
    }

    public static boolean isProductAvailable(int stockQuantity, int requestedQuantity) {
        return stockQuantity >= requestedQuantity;
    }

    public static int updateStockAfterPurchase(int currentStock, int purchasedQuantity) {
        return Math.max(0, currentStock - purchasedQuantity);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy hh:mm a");
        return formatter.format(date);
    }

    public static double calculateAverageRating(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }

        double average = (double) sum / reviews.size();

        return Math.round(average * 10.0) / 10.0;
    }

    public static boolean isAdmin(String userRole) {
        if (isNullOrEmpty(userRole)) {
            return false;
        }
        return userRole.toLowerCase().equals("admin");
    }

    public static boolean validatePayment(String paymentMethod, double amount) {
        if (isNullOrEmpty(paymentMethod) || amount <= 0) {
            return false;
        }

        String lowerCaseMethod = paymentMethod.toLowerCase();
        for (String validMethod : VALID_PAYMENT_METHODS) {
            if (validMethod.equals(lowerCaseMethod)) {
                return true;
            }
        }

        return false;
    }

    public static class ValidationResult {
        private final boolean valid;
        private final String message;

        public ValidationResult(boolean valid, String message) {
            this.valid = valid;
            this.message = message;
        }

        public boolean isValid() {
            return valid;
        }

        public String getMessage() {
            return message;
        }
    }

    public interface OrderItem {
        int getQuantity();
        double getPriceAtPurchase();
    }

    public interface Review {
        int getRating();
    }
}