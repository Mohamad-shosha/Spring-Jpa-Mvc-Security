package com.shosha.springboot.demo.controller.instructorcontroller;

import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import com.shosha.springboot.demo.util.transformation.InstructorTransformation;
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
        List<Instructor> instructors = instructorService.findAllInstructors();
        model.addAttribute("instructors", instructors);
        return "list-instructors";
    }

    @GetMapping("/new")
    public String showInstructorForm(Model model) {
        model.addAttribute("instructor", new InstructorDto());
        return "instructors-form-add";
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

    @GetMapping("/edit/{id}")
    public String showUpdateInstructorForm(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.findById(id);
        model.addAttribute("instructor", instructor);
        return "instructors-form-update";
    }

    @PostMapping("/update/{id}")
    public String updateInstructor(@PathVariable String id, @ModelAttribute Instructor instructor) throws SqlConstraintException {
        InstructorDto instructorDto = InstructorTransformation.transformToInstructorDto(instructor);
        instructorService.update(instructorDto,id);
        return "redirect:/instructors";
    }


    @GetMapping("/{id}")
    public String getInstructor(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.findById(id);
        InstructorDto instructorDto = instructorService.getInstructorDtoById(id);
        model.addAttribute("instructor", instructor);
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
