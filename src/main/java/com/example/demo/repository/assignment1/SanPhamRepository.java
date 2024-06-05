package com.example.demo.repository.assignment1;

import com.example.demo.entites.SanPham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class SanPhamRepository {
    private List<SanPham> ds;
    public SanPhamRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new SanPham(1," Ma01","Ao",1));
        this.ds.add(new SanPham(2," Ma02","Quan",0));
        this.ds.add(new SanPham(3," Ma03","phong",1));
        this.ds.add(new SanPham(4," Ma04","Quan dui",0));
    }
    public List<SanPham> findAll() {
        return this.ds;
    }
    public Page<SanPham> findAll(Pageable pageable, String keyword) {
        List<SanPham> filteredList = ds;
        if (keyword != null && !keyword.isEmpty()) {
            filteredList = ds.stream()
                    .filter(sp -> sp.getTen().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredList.size());

        if (start > end) {
            return new PageImpl<>(Collections.emptyList(), pageable, filteredList.size());
        }
        return new PageImpl<>(filteredList.subList(start, end), pageable, filteredList.size());
    }
    public void create(SanPham sp){
        this.ds.add(sp);
    }
    public void deleteById(int id){
    for (int i =0; i < this.ds.size(); i++){
        SanPham sp = this.ds.get(i);
        if (sp.getId() == id){
            this.ds.remove(i);
        }
    }
    }
    public SanPham findById (int id){
        for (int i = 0; i < this.ds.size() ; i++) {
            SanPham sp = this.ds.get(i);
            if (sp.getId() == id){
                return  sp;
            }
        }
        return null;
    }

    public void update (SanPham newValue){
        for (int i = 0; i < this.ds.size() ; i++) {
            SanPham oldValue = this.ds.get(i);
            if (oldValue.getId() == newValue.getId()){
                this.ds.set(i,newValue);
            }
        }
    }

}

