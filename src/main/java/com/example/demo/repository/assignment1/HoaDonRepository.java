package com.example.demo.repository.assignment1;

import com.example.demo.entites.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonRepository {
    private List<HoaDon> ds;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public HoaDonRepository() {
        ds = new ArrayList<>();
        ds.add(new HoaDon(1, 3, 3, "2020-11-20", 1));
        ds.add(new HoaDon(2, 2, 2, "2020-10-21", 1));
        ds.add(new HoaDon(3, 1, 1, "2020-09-22", 0));
        ds.add(new HoaDon(4, 3, 3, "2003-08-23", 1));
        ds.add(new HoaDon(5, 2, 1, "2020-07-24", 1));
        ds.add(new HoaDon(6, 1, 1, "2003-06-25", 0));
        ds.add(new HoaDon(7, 3, 2, "2004-03-26", 1));
        ds.add(new HoaDon(8, 2, 1, "2005-02-27", 1));
        ds.add(new HoaDon(9, 1, 2, "2006-10-28", 0));
        ds.add(new HoaDon(10, 1, 3, "2000-04-29", 1));
        ds.add(new HoaDon(11, 2, 2, "2003-10-19", 1));
        ds.add(new HoaDon(12, 3, 3, "20022-01-02",0));

    }
    public List<HoaDon> findAll(){
        return ds;
    }
    public Page<HoaDon> findAll(Pageable pageable, String startDate, String endDate) {
        List<HoaDon> filteredList = ds;

        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            filteredList = filteredList.stream()
                    .filter(hd -> {
                        LocalDate ngayLap = LocalDate.parse(hd.getNgayMuaHang(), formatter);
                        return (ngayLap.isEqual(start) || ngayLap.isAfter(start)) && (ngayLap.isEqual(end) || ngayLap.isBefore(end));
                    })
                    .collect(Collectors.toList());
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredList.size());
        if (start > end) {
            return new PageImpl<>(Collections.emptyList(), pageable, filteredList.size());
        }
        return new PageImpl<>(filteredList.subList(start, end), pageable, filteredList.size());
    }

    public void create(HoaDon hd ){
        hd.setId(ds.size()+1);
        ds.add(hd);
    }
    public void deleteByID(int id){
        for (int i = 0; i < ds.size(); i++) {
            HoaDon hd = ds.get(i);
            if(hd.getId() == id){
                ds.remove(i);
            }
        }
    }
    public void update(HoaDon newHD){
        for (int i = 0; i < ds.size(); i++) {
            HoaDon hd = ds.get(i);
            if(hd.getId() == newHD.getId()){
                ds.set(i,newHD);
            }
        }
    }
    public HoaDon findByID(int id){
        for (int i = 0; i < ds.size(); i++) {
            HoaDon hd = ds.get(i);
            if(hd.getId() == id){
                return hd;
            }
        }
        return null;
    }
}
