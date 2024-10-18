import com.shosha.springboot.demo.Main;
import com.shosha.springboot.demo.controller.instructorcontroller.InstructorController;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.CourseDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class InstructorViewModelMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InstructorService instructorService;

    @InjectMocks
    private InstructorController instructorController;

    private Instructor instructor;

    @BeforeEach
    public void setUp() {
        instructor = new Instructor();
        instructor.setId("12345678-xyzv-1234-efgh-123456789abc");
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setBirthDate("1990-05-15");
        instructor.setEmail("john.doe@example.com");
        instructor.setAddressId("0cea66c3-57a1-4e98-9e58-c72e6e060828");
        instructor.setCourseId("34acc222-f07c-4694-8e15-b683eb0fab59");
    }

    @Test
    public void testListInstructors() throws Exception {
        Mockito.when(instructorService.findAllInstructors()).thenReturn(Collections.singletonList(instructor));

        mockMvc.perform(MockMvcRequestBuilders.get("/instructors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("instructors"))
                .andExpect(MockMvcResultMatchers.view().name("list-instructors"));
    }

    @Test
    public void testShowInstructorForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/instructors/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("instructor"))
                .andExpect(MockMvcResultMatchers.view().name("instructors-form-add"));
    }

    @Test
    public void testSaveInstructor() throws Exception {
        InstructorDto instructorDto = InstructorDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .birthDate("1990-05-15")
                .address(new AddressDto("123 Main St",
                        "Springfield",
                        "IL",
                        "62701",
                        "USA")) // Example address
                .course(new CourseDto("Advanced programming with Python",
                        "cs1457",
                        "For Beginners and intermediate students")) // Example course
                .build();
        Mockito.doNothing().when(instructorService).save(ArgumentMatchers.any(InstructorDto.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/instructors/save")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", instructorDto.getFirstName())
                        .param("lastName", instructorDto.getLastName())
                        .param("email", instructorDto.getEmail())
                        .param("birthDate", instructorDto.getBirthDate())
                        .param("address.street", instructorDto.getAddress().getStreet())
                        .param("address.city", instructorDto.getAddress().getCity())
                        .param("address.state", instructorDto.getAddress().getState())
                        .param("address.zip", instructorDto.getAddress().getZip())
                        .param("address.country", instructorDto.getAddress().getCountry())
                        .param("course.name", instructorDto.getCourse().getName())
                        .param("course.code", instructorDto.getCourse().getCode())
                        .param("course.description", instructorDto.getCourse().getDescription()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/instructors"));
    }

    @Test
    public void testSearchInstructor() throws Exception {
        Mockito.when(instructorService.findInstructorByFirstName("John")).thenReturn(Collections.singletonList(instructor));

        mockMvc.perform(MockMvcRequestBuilders.get("/instructors/search").param("firstName", "John"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("instructors"))
                .andExpect(MockMvcResultMatchers.view().name("instructors-search-results"));
    }

    @Test
    public void testShowUpdateInstructorForm() throws Exception {
        Mockito.when(instructorService.findById("12345678-xyzv-1234-efgh-123456789abc")).thenReturn(instructor);

        mockMvc.perform(MockMvcRequestBuilders.get("/instructors/edit/{id}", "12345678-xyzv-1234-efgh-123456789abc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("instructor"))
                .andExpect(MockMvcResultMatchers.view().name("instructors-form-update"));
    }


//    @Test
//    public void testUpdateInstructor() throws Exception {
//        Mockito.when(instructorService.update(ArgumentMatchers.any(InstructorDto.class), ArgumentMatchers.eq("12345678-xyzv-1234-efgh-123456789abc"))).thenReturn(instructor);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/instructors/update/{id}", "12345678-xyzv-1234-efgh-123456789abc")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("firstName", "John")
//                        .param("lastName", "Doe")
//                        .param("email", "john.doe@example.com"))
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/instructors"));
//    }

    @Test
    public void testDeleteInstructor() throws Exception {
        Mockito.doNothing().when(instructorService).delete("12345678-xyzv-1234-efgh-123456789abc");

        mockMvc.perform(MockMvcRequestBuilders.get("/instructors/delete/{id}", "12345678-xyzv-1234-efgh-123456789abc"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/instructors"));
    }

    @Test
    public void testGetInstructorDetails() throws Exception {
        Mockito.when(instructorService.findById("12345678-xyzv-1234-efgh-123456789abc")).thenReturn(instructor);

        mockMvc.perform(MockMvcRequestBuilders.get("/instructors/{id}", "12345678-xyzv-1234-efgh-123456789abc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("instructor"))
                .andExpect(MockMvcResultMatchers.view().name("instructor-details"));
    }
}
