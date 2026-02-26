import java.util.*;

public class Patient extends Person {
    private String gender;
    private String phone;
    private List<String> symptoms;
    private String recordDate;
    private String recordDescription;
    private String emergency;

    public Patient(String id, String name, int age, String gender, String phone,
                   List<String> symptoms, String recordDate, String recordDescription, String emergency) {
        super(id, name, age);
        this.gender = gender;
        this.phone = phone;
        this.symptoms = symptoms;
        this.recordDate = recordDate;
        this.recordDescription = recordDescription;
        this.emergency = emergency;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmergency() {
        return emergency;
    }

    public String getDetails() {
        return "ID: " + id + " | Patient: " + name + " | Gender: " + gender + " | Age: " + age +
               " | Phone: " + phone + " | Symptoms: " + symptoms +
               " | Record Date: " + recordDate + " | Description: " + recordDescription +
               (emergency.isEmpty() ? "" : " | Emergency: " + emergency);
    }
}
