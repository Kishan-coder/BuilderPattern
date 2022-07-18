import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;
//builder pattern ensuring immutability (useful for reading concurrent objects),
//easier global validations and type-safe with no explicit type check for all fields
public class NewStudent {
    private static NewStudent newStudent1;
    static {
        newStudent1 = new NewStudent();
    }
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;

    private NewStudent(){}

    //step1 - create inner builder class with same fields in outer main class
    public static class NewStudentBuilder{

        private NewStudent newStudent = new NewStudent();

        public String getfName() {
            return newStudent.fName;
        }

        public NewStudentBuilder setfName(String fName) {
            newStudent.fName = fName;
            return this;
        }

        public String getlName() {
            return newStudent.lName;
        }

        public NewStudentBuilder setlName(String lName) {
            newStudent.lName = lName;
            return this;
        }

        public String getEmail() {
            return newStudent.email;
        }

        public NewStudentBuilder setEmail(String email) {
            newStudent.email = email;
            return this;
        }

        public String getPhone() {
            return newStudent.phone;
        }

        public NewStudentBuilder setPhone(String phone) {
            newStudent.phone = phone;
            return this;
        }

        public String getAddress() {
            return newStudent.address;
        }

        public NewStudentBuilder setAddress(String address) {
            newStudent.address = address;
            return this;
        }

        //elegant way of setting fields using chaining method aka fluent interfaces
        public NewStudentBuilder withName(String fName, String lName){
            newStudent.fName = fName;
            newStudent.lName = lName;
            return this;
        }

        public NewStudentBuilder withContactInfo(String phone, String email){
            newStudent.phone = phone;
            newStudent.email = email;
            return this;
        }

        public boolean validate(){
            if (newStudent.fName.isEmpty() || newStudent.lName == null)
                return false;
            if (!StringUtils.isNumeric(newStudent.phone) || newStudent.phone.length() != 10) {
                System.out.println("Given Phone Number should be exactly 10 digit Number");
                return false;
            }
            EmailValidator validator = EmailValidator.getInstance();
            if (!validator.isValid(newStudent.email)) {
                System.out.println("Invalid Email Address provided by client.");
                return false;
            }
            return true;
        }

        //step2 - create build method for outer class instance
        public NewStudent build() throws IllegalStateException{
            //step 3 - validate first
            if (validate()) {
                return newStudent;
            } else{
                throw new IllegalStateException("Invalid Student.");
            }
        }
    }
}
