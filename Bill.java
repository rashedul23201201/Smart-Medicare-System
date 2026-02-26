public class Bill {
    private String patientId;
    private double amount;
    private String method;
    private String status;

    public Bill(String patientId, double amount, String method, String status) {
        this.patientId = patientId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public String getDetails() {
        return "Bill => Patient ID: " + patientId +
               " | Amount: " + amount + " | Method: " + method + " | Status: " + status;
    }
}
