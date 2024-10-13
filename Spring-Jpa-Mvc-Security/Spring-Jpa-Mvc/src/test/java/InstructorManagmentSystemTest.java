import com.shosha.springboot.demo.InstructorsManagmentSystem;
import com.shosha.springboot.demo.dao.instructorrepository.InstructorRepository;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = InstructorsManagmentSystem.class)
public class InstructorManagmentSystemTest {
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorService instructorService;

    @BeforeEach
    public void setUp() {
        jdbc.execute("insert into instructor(instructor_id, first_name, last_name, date_of_birth, email, address_id, course_id) " +
                "VALUES ('12345678-xyzv-1234-efgh-123456789abc', 'John', 'Doe', '1990-05-15', 'john.doe@example.com', NULL, NULL);");
    }

    @Test
    public void isStudentNullCheck() {
        assertTrue(instructorService.isNullOrNot("6bd15419-2bc6-42da-adcc-4c61e361b861"));
        assertFalse(instructorService.isNullOrNot("ea7ccec0-a718-4c43-888e-f5da2e66a39b"));
    }

    @Test
    public void getInstructorsSizeInDatabase() {
        List<Instructor> instructors = instructorService.findAllInstructors();
        assertEquals(10, instructors.size());
    }

    @Test
    public void getSpecificInstructor() {
        assertTrue(instructorService.isNullOrNot("12345678-xyzv-1234-efgh-123456789abc"));
    }

    @AfterEach
    public void tearDown() {
        jdbc.execute("DELETE FROM instructor WHERE instructor_id = '12345678-xyzv-1234-efgh-123456789abc';");
    }


}
