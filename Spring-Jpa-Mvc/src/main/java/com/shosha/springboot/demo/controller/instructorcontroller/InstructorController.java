package com.shosha.springboot.demo.controller.instructorcontroller;

import com.shosha.springboot.demo.dao.addressrepository.AddressRepository;
import com.shosha.springboot.demo.dao.courserepository.CourseRepository;
import com.shosha.springboot.demo.error.exception.InstructorNotFoundException;
import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String listInstructors(Model model) {
        List<InstructorDto> instructors = instructorService.findAll();
        model.addAttribute("instructors", instructors);
        return "list-instructors";
    }

    @GetMapping("/new")
    public String showInstructorForm(Model model) {
        model.addAttribute("instructor", new InstructorDto());
        return "instructors-form";
    }

    @PostMapping("/save")
    public String saveInstructor(@ModelAttribute InstructorDto instructorDto) throws SqlConstraintException {
        instructorService.save(instructorDto);
        return "redirect:/instructors";
    }

    @GetMapping("/search")
    public String searchInstructor(@RequestParam String firstName, Model model) {
        List<InstructorDto> instructors = instructorService.findAllByFirstName(firstName);
        model.addAttribute("instructors", instructors);
        return "instructors-search-results";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateInstructorForm(@PathVariable String id, Model model) {
        InstructorDto instructorDto = instructorService.getInstructorDtoById(id);
        model.addAttribute("instructor", instructorDto); // Ensure this line is correct
        return "instructors-form-update"; // Points to the correct update form
    }

    @GetMapping("/{id}")
    public String getInstructor(@PathVariable String id, Model model) {
        InstructorDto instructorDto = instructorService.getInstructorDtoById(id);
        model.addAttribute("instructor", instructorDto);
        return "instructor-details";
    }

    @GetMapping("/{email}/courseCode")
    public String getCourseCodeOfTheInstructor(@PathVariable String email, Model model) {
        String courseCode = instructorService.findCourseCodeByEmail(email);
        model.addAttribute("courseCode", courseCode);
        return "instructor-course-code";
    }

    @GetMapping("/{email}/address")
    public String getAddressOfTheInstructor(@PathVariable String email, Model model) {
        AddressDto addressDto = instructorService.findAddressByEmail(email);
        model.addAttribute("address", addressDto);
        return "instructor-address";
    }

    @PostMapping("/{id}/delete")
    public String deleteInstructorById(@PathVariable String id) {
        instructorService.delete(id);
        return "redirect:/instructors";
    }

    @GetMapping("/course/{courseName}/address")
    public String getAddressByCourseName(@PathVariable String courseName, Model model) {
        AddressDto addressDto = instructorService.findAddressByCourseName(courseName);
        model.addAttribute("address", addressDto);
        return "course-address";
    }
}
