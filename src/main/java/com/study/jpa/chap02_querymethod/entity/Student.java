package com.study.jpa.chap02_querymethod.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter @Getter // 실무적 측면에서 setter는 신중하게 선택할 것
@ToString @EqualsAndHashCode(of = "id")  // if id is same, recognize as same object
// (of = {"id", "name" , etc} -> if annotation based on various values; String array
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "stu_id") // field name = id / column name = stu_id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid", name = "uid") // set primary key value using UUID
    private String id; // String type is not available to use auto-increment

    @Column(name = "stu_name", nullable = false)
    private String name;

    private String city;

    private String major;

}
