public class Doctor extends Person {
    private String specialization;
    private String availableTime;
    private String availableDays;
    private double consultationFee;

    public Doctor(String id, String name, int age, String specialization,
                  String availableTime, String availableDays, double consultationFee) {
        super(id, name, age);
        this.specialization = specialization;
        this.availableTime = availableTime;
        this.availableDays = availableDays.toLowerCase();
        this.consultationFee = consultationFee;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public String getDetails() {
        return "Doctor: " + name + " | Specialization: " + specialization +
               " | Available: " + availableDays + " at " + availableTime +
               " | Fee: " + consultationFee;
    }
}
