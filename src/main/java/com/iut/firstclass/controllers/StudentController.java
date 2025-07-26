package com.iut.firstclass.controllers;

import lombok.RequiredArgsConstructor;
import com.iut.firstclass.Dto.AttendanceDto;
import com.iut.firstclass.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.iut.firstclass.services.StudentService;
import com.iut.firstclass.models.entity.Student;
import com.iut.firstclass.repositories.StudentRepository;

// AttendanceType.java
import java.time.LocalDate;
import java.util.List;

// StudentController.java
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }


    @GetMapping("/findbyid/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/addNewStudent")
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/getStudentAttendance")
    public List<AttendanceDto> getStudentAttendance() {
        return studentService.findAttendanceOfStudentByIdAndDate(1L,
                LocalDate.now(), LocalDate.now().plusDays(20));
    }

    @PostMapping("/seeddata")
    public String seedAttendance(@RequestBody AttendanceDto attendanceDto) {
        studentService.saveAttendance(attendanceDto);
        return "data saved";
    }

    @GetMapping("/getAllAttendanceByDate")
    public List<AttendanceDto> getAllAttendanceByDate(@RequestParam("date") String date) {
        return studentService.findAllAttendanceByDate(LocalDate.parse(date));
    }

}
