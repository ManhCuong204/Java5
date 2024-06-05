package com.example.demo.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Target;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPhamChiTiet")
public class SPCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="IdMauSac")
    private Integer idMS;


    @Column(name="IdKichThuoc")
    private Integer idKT;

    @Column(name="IdSanPham")
    private Integer idSP;

    @ManyToOne()
    @JoinColumn(
            name="IdSanPham",
            referencedColumnName = "ID",insertable = false,updatable = false
    )
    private SanPham sp;

    @Column(name="MaSPCT")
    private String maSPCT;

    @Column(name="SoLuong")
    private Integer soLuong;

    @Column(name="DonGia")
    private double donGia;

    @Column(name="TrangThai")
    private int trangThai;
}
