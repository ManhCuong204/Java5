package com.example.demo.repository.assignment1;

import com.example.demo.entites.SPCT;
import com.example.demo.entites.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SPCTRepository {
    private List<SPCT> ds;



    public List<SPCT> findAll() {
        return this.ds;
    }

        public void create(SPCT ctsp ){
            ctsp.setId(ds.size()+1);
            ds.add(ctsp);
        }
        public void deleteByID(int id){
            for (int i = 0; i < ds.size(); i++) {
                SPCT ctsp = ds.get(i);
                if(ctsp.getId() == id){
                    ds.remove(i);
                }
            }
        }
        public void update(SPCT newCTSP){
            for (int i = 0; i < ds.size(); i++) {
               SPCT ctsp = ds.get(i);
                if(ctsp.getId() == newCTSP.getId()){
                    ds.set(i,newCTSP);
                }
            }
        }
        public SPCT findByID(int id){
            for (int i = 0; i < ds.size(); i++) {
               SPCT ctsp = ds.get(i);
                if(ctsp.getId() == id){
                    return ctsp;
                }
            }
            return null;
        }
        public List<SPCT> findByidSP(Integer idSP){
            if(idSP == null){
                return ds;
            }
            List<SPCT> kq = new ArrayList<>();
            for(SPCT ct: ds){
                if(ct.getIdSP() == idSP){
                    kq.add(ct);
                }
            }
            return kq;
    }
}