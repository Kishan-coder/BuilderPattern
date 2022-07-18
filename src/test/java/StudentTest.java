import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testStudent1(){
        // it is pain in the a**
        // requires explicit validation logic and not immutable
        Student s = new Student();
        s.setfName("Kishan");
        s.setlName("Kashyap");
        s.setEmail("kishankashyap5m@gmail.com");
        s.setPhone("09958228189");
        s.setAddress("Mannat, Murthal, Delhi-Karnal Highway");
        Assertions.assertTrue("Kishan".equals(s.getfName()), "Failure: fName is not set for student");
    }

    // no setters for tests from here
    @Test
    public void testStudent2(){
        // immutable instances with constructor
        // but global validation logic would be clumsy
        // also difficult as ordering requires to be remembered
        Student s = new Student("Kishan", "Kashyap", "user@example.com", "9999999999", "WhiteHouse, Washington DC");
        Assertions.assertTrue("Kishan".equals(s.getfName()), "Failure: fName is not set for student");
    }

    @Test
    public void testStudent3() throws RuntimeException{
        // creates immutable objects
        // no need for setters as optional fields need not be added in the hashmap
        HashMap<String, Object> myStudentMap = new HashMap<>();
        myStudentMap.put("fName", "Kishan");
        myStudentMap.put("lName", "Kashyap");
        Student s = new Student(myStudentMap);
        Assertions.assertNull(s.getEmail());
    }

    @Test
    public void testStudent4(){
        // test for global validation check
        // type-saftey with hashmap, no need to remember the ordering of constructor arguments
        HashMap<String, Object> myStudentMap = new HashMap<>();
        myStudentMap.put("email", "kk@rediff.com");
        myStudentMap.put("lName", "Kashyap");
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new Student(myStudentMap);
        });
        assertEquals("First Name not passed!", exception.getMessage());
    }

}
