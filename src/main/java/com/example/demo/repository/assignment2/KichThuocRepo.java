package com.example.demo.repository.assignment2;

import com.example.demo.entites.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepo extends JpaRepository<KichThuoc,Integer> {
}
