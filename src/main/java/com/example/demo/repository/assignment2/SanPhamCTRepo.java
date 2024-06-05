package com.example.demo.repository.assignment2;

import com.example.demo.entites.SPCT;
import com.example.demo.entites.SPCTCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamCTRepo extends JpaRepository<SPCT, Integer> {
    @Query(
            "SELECT new SPCTCustom (" +
                    " spct.id, spct.idMS, spct.idKT, sp.ten, spct.maSPCT, " +
                    " spct.soLuong, spct.donGia, spct.trangThai)" +
                    " FROM SPCT spct JOIN SanPham sp ON spct.idSP = sp.id where (:idSP is null or sp.id = :idSP )"
    )
     List<SPCTCustom> findAllByIdSP(@Param("idSP") Integer idSP);
}
