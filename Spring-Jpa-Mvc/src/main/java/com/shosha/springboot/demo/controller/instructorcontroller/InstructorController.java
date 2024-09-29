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
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService,
                                AddressRepository addressRepository, CourseRepository courseRepository) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public String listInstructors(Model model) {
        List<InstructorDto> instructors = instructorService.findAll();
        model.addAttribute("instructors", instructors);
        return "list-instructors";
    }

    @GetMapping("/instructors/new")
    public String showInstructorForm(Model model) {
        model.addAttribute("instructor", new InstructorDto());
        return "instructor-form";
    }

    @PostMapping("/instructors/save")
    public String saveInstructor(@ModelAttribute InstructorDto instructorDto) throws SqlConstraintException  {
        instructorService.save(instructorDto);
        return "redirect:/instructors";
    }

    @GetMapping("/instructors/search")
    public String searchInstructor(@RequestParam String firstName, Model model) {
        List<InstructorDto> instructors = instructorService.findAllByFirstName(firstName);
        model.addAttribute("instructors", instructors);
        return "instructor-search-results";
    }

    @PutMapping("UpdateInstructor/{id}")
    public void updateInstructor(@RequestBody InstructorDto instructorDto,
                                 @PathVariable String id) throws InstructorNotFoundException {
        instructorService.update(instructorDto, id);
    }

    @GetMapping("GetInstructor/{id}")
    public InstructorDto getInstructor(@PathVariable String id) {
        return instructorService.getInstructorDtoById(id);
    }

/*    @GetMapping("GetId/{email}")
    public String getIdOfTheInstructor(@PathVariable String email) {
        return instructorService.findIdByEmail(email);
    }*/

    @GetMapping("GetCourseCode/{email}")
    public String getCourseCodeOfTheInstructor(@PathVariable String email) {
        return instructorService.findCourseCodeByEmail(email);
    }

    @GetMapping("GetAddress/{email}")
    public AddressDto getAddressOfTheInstructor(@PathVariable String email) {
        return instructorService.findAddressByEmail(email);
    }

    @DeleteMapping("DeleteInstructor/{id}")
    public void deleteInstructorById(@PathVariable String id) {
        instructorService.delete(id);
    }

    @GetMapping("GetAddressByCourseName/{courseName}")
    public AddressDto getAddressByCourseName(@PathVariable String courseName) {
        return instructorService.findAddressByCourseName(courseName);
    }

}
