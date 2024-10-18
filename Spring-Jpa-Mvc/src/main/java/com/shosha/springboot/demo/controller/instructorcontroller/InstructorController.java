package com.shosha.springboot.demo.controller.instructorcontroller;

import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import com.shosha.springboot.demo.util.transformation.InstructorTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
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
        List<Instructor> instructor = instructorService.findInstructorByFirstName(firstName);
        model.addAttribute("instructors", instructor);
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
        instructorService.update(instructorDto, id);
        return "redirect:/instructors";
    }

    @GetMapping("/{id}")
    public String getInstructor(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.findById(id);
        InstructorDto instructorDto = instructorService.getInstructorDtoById(id);
        model.addAttribute("instructor", instructor);
        return "instructor-details";
    }

    @GetMapping("/getCourseCode")
    public String getCourseCodeOfTheInstructor(Model model) {
        model.addAttribute("instructorEmail", new InstructorDto());
        return "instructors-get-course-code";
    }

    @GetMapping("/courseCode")
    public String getCourseCodeOfTheInstructorWithEmail(@RequestParam String email, Model model) {
        Optional<Instructor> instructor = instructorService.findInstructorByEmail(email);
        if (instructor.isPresent()) {
            model.addAttribute("instructorDto",
                    InstructorTransformation.transformToInstructorDto(instructor.get()));
            return "instructor-course-code";
        } else
            return "redirect:/instructors";
    }

    @GetMapping("/getAddress")
    public String getAddressOfTheInstructor(Model model) {
        model.addAttribute("instructorAddress", new InstructorDto());
        return "instructors-get-address";
    }

    @GetMapping("/address")
    public String getAddressOfTheInstructor(@RequestParam String email, Model model) {
        Optional<Instructor> instructor = instructorService.findInstructorByEmail(email);
        if (instructor.isPresent()) {
            model.addAttribute("instructorDto",
                    InstructorTransformation.transformToInstructorDto(instructor.get()));
            return "instructor-address";
        } else {
            return "redirect:/instructors";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteInstructorById(@PathVariable String id) {
        instructorService.delete(id);
        return "redirect:/instructors";
    }

    @GetMapping("/getCourse")
    public String getAddressByCourseName(Model model) {
        model.addAttribute("courseAddress", new InstructorDto());
        return "instructors-get-address-course-name";
    }

    @GetMapping("/course/address")
    public String getAddressByCourseName(@RequestParam String courseName, Model model) {
        AddressDto addressDto = instructorService.findAddressByCourseName(courseName);
        model.addAttribute("address", addressDto);
        return "course-address";
    }

}
