package com.study.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // if oracle GenerationType.SEQUENCE
    @Column(name = "prod_id", nullable = false, unique = true, length = 30) // field name = id, column = prod_id
    private long id; // GenerationType.IDENTITY = auto_increment: no need to make sequence & insert values
    @Column(name = "prod_name")
    private String name;

    private int price; // if you want to set default value, just give

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp // default sysdate(oracle) / default current_timestamp(mysql, mariadb)
    @Column(updatable = false) // make impossible to modify values
    private LocalDateTime createDate;

    @UpdateTimestamp // set time values automatically when updated
    private LocalDateTime updateDate;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }

}
