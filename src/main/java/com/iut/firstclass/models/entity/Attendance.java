package com.iut.firstclass.models.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

import com.iut.firstclass.models.entity.Student;
import com.iut.firstclass.models.enums.AttendanceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceType attendanceType;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}