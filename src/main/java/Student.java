import java.util.HashMap;

public class Student {
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;

    public Student(String fName, String lName, String email, String phone, String address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Student(HashMap<String, Object> inputMap) throws RuntimeException{
        //global validation will be like
        if (fName == null)
            throw new RuntimeException("First Name not passed!");
        fName = (String)inputMap.get("fName");
        lName = (String)inputMap.get("lName");
    }

    public Student(){};

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
