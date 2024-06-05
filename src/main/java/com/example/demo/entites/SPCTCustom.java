package com.example.demo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SPCTCustom {
    @Id
    private Integer id;
    private int idMS;
    private int idKT;
    private String tenSP;
    private String maSPCT;
    private int soLuong;
    private double donGia;
    private int trangThai;
}

