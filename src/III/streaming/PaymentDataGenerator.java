import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Payment {
    private String transactionId;
    private String userId;
    private double amount;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
    private String category;

    public Payment(String transactionId, String userId, double amount, LocalDateTime transactionDate, 
                   String paymentMethod, String status, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.category = category;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Payment{ID=%s, User=%s, Amount=%.2f, Date=%s, Method=%s, Status=%s, Category=%s}",
                transactionId, userId, amount, transactionDate, paymentMethod, status, category);
    }

    public static List<Payment> generateSamplePayments(int count) {
        Random random = new Random();
        List<String> users = Arrays.asList("U001", "U002", "U003", "U004", "U005");
        List<String> paymentMethods = Arrays.asList("Credit Card", "Debit Card", "PayPal", "Bank Transfer");
        List<String> statuses = Arrays.asList("Completed", "Pending", "Failed");
        List<String> categories = Arrays.asList("Groceries", "Entertainment", "Utilities", "Travel", "Shopping");

        return IntStream.range(0, count).mapToObj(i -> new Payment(
                "TXN" + (1000 + i),
                users.get(random.nextInt(users.size())),
                10 + (500 * random.nextDouble()),
                LocalDateTime.now().minusDays(random.nextInt(30)),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                statuses.get(random.nextInt(statuses.size())),
                categories.get(random.nextInt(categories.size()))
        )).collect(Collectors.toList());
    }
}

public class PaymentDataGenerator {
    public static void main(String[] args) {
        List<Payment> payments = Payment.generateSamplePayments(100);
        payments.forEach(System.out::println);

        Map<String, Double> topSpendingUsers = payments.stream()
                .collect(Collectors.groupingBy(Payment::getUserId, Collectors.summingDouble(Payment::getAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("TOP3: " + topSpendingUsers);

        String mostPopularPayment = payments.stream()
                .filter(payment -> payment.getAmount() >= 200)
                .collect(Collectors.groupingBy(Payment::getPaymentMethod, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("nelzeUrcit");

        System.out.println(mostPopularPayment);

        LocalDate today = LocalDate.now();
        Map<String, List<Payment>> timePayments = payments.stream()
                .collect(Collectors.groupingBy(payment -> {
                    LocalDate dateOfTransaction = payment.getTransactionDate().toLocalDate();
                    if (dateOfTransaction.isEqual(today)){
                        return "Today";
                    } else if (dateOfTransaction.isAfter(today.minusDays(7))) {
                        return "Week";
                    } else if (dateOfTransaction.isAfter(today.minusDays(30))) {
                        return "Month";
                    } else {
                        return "Older";
                    }
                }));

        timePayments.forEach((key, value) -> {
            System.out.println(key + ": " + value.size())
            ;
        });


    }
}

