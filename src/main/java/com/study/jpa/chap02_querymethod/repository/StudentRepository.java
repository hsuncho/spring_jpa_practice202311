package com.study.jpa.chap02_querymethod.repository;

import com.study.jpa.chap02_querymethod.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, String> {
    // JpaRepository(Entity type, pk type)

    List<Student> findByName(String name);
    // findBy + 'field name' -> able to get data

    List<Student> findByCityAndMajor(String city, String major);

    List<Student> findByMajorContaining(String major);
    // asks if specific major contains or not

    // 네이티브 쿼리 사용
    @Query(value = "SELECT * FROM tbl_student WHERE stu_name = :nm", nativeQuery = true)
    Student findNameWithSQL(@Param("nm") String name);
}
