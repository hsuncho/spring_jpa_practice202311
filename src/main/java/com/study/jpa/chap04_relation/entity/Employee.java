package com.study.jpa.chap04_relation.entity;

import lombok.*;

import javax.persistence.*;

@Setter @Getter // Setter is usually not recommended in Entity
@ToString
@EqualsAndHashCode( of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @ManyToOne // one(single)-way Mapping
    @JoinColumn(name = "dept_id") // give Jpa information of FK for JOIN
    private Department department; // employee should have information of department

    // department is an object which has all of info(id, name)
    // database is not object-oriented so only set dept_id as FK to execute JOIN
    // entity with FK declares annotation

}
