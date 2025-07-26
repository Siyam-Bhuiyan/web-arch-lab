package com.iut.firstclass.Dto;

import com.iut.firstclass.models.enums.AttendanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
    private Long studentId;
    private LocalDate date;
    private AttendanceType attendanceType;
}
