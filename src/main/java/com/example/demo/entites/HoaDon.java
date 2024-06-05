package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private Integer idNV;
private Integer idKH;
private String ngayMuaHang;
private Integer trangThai;
}
