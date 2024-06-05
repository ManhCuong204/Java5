package com.example.demo.repository.assignment1;

import com.example.demo.entites.MauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private List<MauSac> ds;
    public MauSacRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1,"MS001","Gray",1));
        this.ds.add(new MauSac(2,"MS002","Red",0));
    }
    public List<MauSac> findAll(){
        return this.ds;
    }
    public void create(MauSac ms){
        this.ds.add(ms);
    }
    public void deleteById(int id){
        for (int i =0; i<this.ds.size(); i++){
            MauSac ms = this.ds.get(i);
            if (ms.getId() == id){
                this.ds.remove(i);
            }
        }
    }
    public MauSac findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if (ms.getId() == id){
                return ms;
            }
        }
        return null;
    }
    public void update(MauSac newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac oldValue = this.ds.get(i);
            if (oldValue.getId() == newValue.getId()){
                this.ds.set(i,newValue);
            }
        }
    }

}
