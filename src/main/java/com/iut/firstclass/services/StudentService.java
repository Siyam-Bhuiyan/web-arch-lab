package com.iut.firstclass.services;

import com.iut.firstclass.Dto.AttendanceDto;
import com.iut.firstclass.models.entity.Attendance;
import com.iut.firstclass.repositories.AttendanceRepository;
import com.iut.firstclass.repositories.StudentRepository;
import com.iut.firstclass.models.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<AttendanceDto> findAllAttendanceByDate(LocalDate date) {
        return attendanceRepository.findAllAttendanceByDate(date);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<AttendanceDto> findAttendanceOfStudentByIdAndDate(Long id, LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findAllAttendanceByStudentBetweenDates(id, startDate, endDate);
    }


    public void saveAttendance(AttendanceDto attendanceDto) {
        Student student = studentRepository.findById(attendanceDto.getStudentId()).orElse(null);
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(attendanceDto.getDate());
        attendance.setAttendanceType(attendanceDto.getAttendanceType());
        attendanceRepository.save(attendance);
    }
}