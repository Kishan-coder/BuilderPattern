import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewStudentTest {

    @Test
    public void testNewStudent1(){
        NewStudent.NewStudentBuilder newStudentBuilder = new NewStudent.NewStudentBuilder();
        // fluent interfaces or method chaining
        newStudentBuilder.setfName("Kishan").setlName("Kashyap").setEmail("kk@example.com").setPhone("9999999999");
        NewStudent newStudent = newStudentBuilder.build();
        Assertions.assertTrue("Kashyap".equals(newStudentBuilder.getlName()));
    }

    @Test
    public void testNewStudent2(){
        NewStudent.NewStudentBuilder newStudentBuilder = new NewStudent.NewStudentBuilder();
        newStudentBuilder.withName("Kishan", "Kashyap").withContactInfo("9999999999", "kk@example.com");
        NewStudent newStudent = newStudentBuilder.build();
        Assertions.assertNotNull(newStudentBuilder.getfName());
    }

    @Test
    public void testNewStudent3(){
        NewStudent.NewStudentBuilder newStudentBuilder = new NewStudent.NewStudentBuilder();
        newStudentBuilder.withName("Kishan", "Kashyap").withContactInfo("9999999999", "kk@example");
        Assertions.assertThrows(IllegalStateException.class, () -> {
            newStudentBuilder.build();
        });
    }

    @Test
    public void testNewStudent4(){
        NewStudent.NewStudentBuilder newStudentBuilder = new NewStudent.NewStudentBuilder();
        newStudentBuilder.withName("Kishan", "Kashyap").withContactInfo("99999k9999", "kk@example.com");
        Assertions.assertThrows(IllegalStateException.class, () -> {
            newStudentBuilder.build();
        });
    }

}
