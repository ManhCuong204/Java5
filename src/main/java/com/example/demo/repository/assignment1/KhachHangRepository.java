package com.example.demo.repository.assignment1;

import com.example.demo.entites.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private List<KhachHang> ds;
    public KhachHangRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KhachHang(1,"KH001","Linh","012748",0));
        this.ds.add(new KhachHang(2,"KH002","A","012749",1));
        this.ds.add(new KhachHang(3,"KH003","B","012747",0));
    }
    public List<KhachHang> findAll(){
        return this.ds;
    }
    public void create(KhachHang kh){
        this.ds.add(kh);
    }
    public void deleteById(int id){
        for (int i = 0; i< this.ds.size(); i++){
            KhachHang kh = this.ds.get(i);
            if (kh.getId() == id){
                this.ds.remove(i);
            }
        }
    }
    public KhachHang findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang kh = this.ds.get(i);
            if (kh.getId() ==id){
                return kh;
            }
        }
        return null;
    }
    public void update(KhachHang newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            KhachHang oldValue =this.ds.get(i);
            if (oldValue.getId() == newValue.getId()){
                this.ds.set(i,newValue);
            }

        }
    }

}
