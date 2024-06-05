package com.example.demo.repository.assignment2;

import com.example.demo.entites.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
}
