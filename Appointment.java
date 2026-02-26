public class Appointment {
    private String patientId;
    private String doctorId;
    private String date;
    private String time;

    public Appointment(String patientId, String doctorId, String date, String time) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public String getDetails() {
        return "Appointment => Patient ID: " + patientId +
               " | Doctor ID: " + doctorId + " | Date: " + date + " | Time: " + time;
    }
}
