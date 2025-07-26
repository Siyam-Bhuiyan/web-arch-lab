package com.iut.firstclass.repositories;

import com.iut.firstclass.Dto.AttendanceDto;
import com.iut.firstclass.models.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query("select new com.iut.firstclass.Dto.AttendanceDto(a.student.id, a.date, a.attendanceType) " +
            "from Attendance a " +
            "where a.student.id = :studentId " +
            "and a.date between :startDate and :endDate")
    List<AttendanceDto> findAllAttendanceByStudentBetweenDates(
            @Param("studentId") Long studentId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("select new com.iut.firstclass.Dto.AttendanceDto(a.student.id, a.date, a.attendanceType) " +
            "from Attendance a " +
            "where a.date = :date")
    List<AttendanceDto> findAllAttendanceByDate(@Param("date") LocalDate date);


}