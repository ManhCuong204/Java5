package com.example.demo.entites;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Login {
    private Integer id;


    @NotBlank(message = "Tên tài khoản không được để trống")
    private String usern;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String passw;

    @NotNull(message = "Vui lòng chọn quyền truy cập")
    private Integer pq;
}
