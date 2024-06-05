package com.example.demo.repository.assignment1;

import com.example.demo.entites.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private List<NhanVien> ds;
    public NhanVienRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new NhanVien(1," Linh", " NV001","AA"," 0123",1));
        this.ds.add(new NhanVien(2," Linh11", " NV002","BB"," 123",0));
    }
    public List<NhanVien> findAll(){
        return this.ds;
    }
    public void create(NhanVien nv){
        this.ds.add(nv);
    }
    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getId() == id){
                this.ds.remove(i);
            }
        }
    }
    public NhanVien findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getId() == id){
                return nv;
            }
        }
        return null;
    }
    public NhanVien findByUsername(String username){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien nv = this.ds.get(i);
            if (nv.getTenDN() == username){
                return nv;
            }
        }
        return null;
    }
    public void update(NhanVien newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            NhanVien oldValue = this.ds.get(i);
            if (oldValue.getId() == newValue.getId()){
                this.ds.set(i,newValue);
            }
        }
    }
}
