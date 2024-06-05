package com.example.demo.repository.assignment1;

import com.example.demo.entites.KichThuoc;
import com.example.demo.entites.MauSac;

import java.util.ArrayList;
import java.util.List;

public class KichThuocRepository {
    private List<KichThuoc> ds;
    public KichThuocRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1, "KT001","AA", 0));
        this.ds.add(new KichThuoc(2, "KT002","AB", 1));
    }
    public List<KichThuoc> findAll(){
        return this.ds;
    }
    public void create(KichThuoc kt){
        this.ds.add(kt);
    }
    public void deleteById(int id){
        for (int i =0; i<this.ds.size(); i++){
            KichThuoc kt  = this.ds.get(i);
            if (kt.getId() == id){
                this.ds.remove(i);
            }
        }
    }
    public KichThuoc findById(int id){
        for (int i =0; i<this.ds.size(); i++){
            KichThuoc kt  = this.ds.get(i);
            if (kt.getId() == id){
               return kt;
            }
        }
        return null;
    }
    public  void update(KichThuoc newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc oldValue = this.ds.get(i);
            if (oldValue.getId() == newValue.getId()){
                this.ds.set(i,newValue);
            }
        }
    }
}
