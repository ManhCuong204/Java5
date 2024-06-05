package com.example.demo.repository.assignment2;

import com.example.demo.entites.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
}
