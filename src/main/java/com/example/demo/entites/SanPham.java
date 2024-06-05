package com.example.demo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Component
//có 4 cách để tạo bean
//@Controller, @Component @Service @
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id @GeneratedValue
    private Integer id;
    @NotBlank
    private String ma;
    @NotBlank
    private String ten;
    @NotNull
    @Digits(integer = 1, fraction = 0)
    private Integer trangThai;
}
