package com.example.demo.repository.assignment1;

import com.example.demo.entites.HDCT;

import com.example.demo.entites.HoaDon;
import com.example.demo.entites.SPCT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class HDCTRepo {

        List<HDCT> ds = new ArrayList<>();

        public HDCTRepo() {
            ds = new ArrayList<>();
            ds.add(new HDCT(1, 1, 1, 20, 3000, 1, "2023/11/11"));
            ds.add(new HDCT(2, 2, 2, 20, 3000, 1, "2023/11/11"));
            ds.add(new HDCT(3, 3, 1, 25, 3000, 0, "2023/11/11"));
            ds.add(new HDCT(4, 1, 2, 15, 2500, 1, "2023/11/12"));
            ds.add(new HDCT(5, 2, 1, 18, 2700, 1, "2023/11/12"));
            ds.add(new HDCT(6, 3, 2, 22, 3200, 0, "2023/11/12"));
            ds.add(new HDCT(7, 1, 3, 17, 2800, 1, "2023/11/13"));
            ds.add(new HDCT(8, 2, 3, 16, 2600, 1, "2023/11/13"));
            ds.add(new HDCT(9, 3, 1, 19, 2900, 0, "2023/11/13"));
            ds.add(new HDCT(10, 1, 2, 21, 3100, 1, "2023/11/14"));
        }
        public List<HDCT> findAll(){
            return ds;
        }

        public List<HDCT> findByidHD(Integer idHD){
            if(idHD == null){
                return ds;
            }
            List<HDCT> kq = new ArrayList<>();
            for(HDCT  ct: ds){
                if(ct.getIdHD()== idHD){
                    kq.add(ct);
                }
            }
            return kq;
        }
        public void update(HDCT newCTHD){
            for (int i = 0; i < ds.size(); i++) {
                HDCT cthd = ds.get(i);
                if(cthd.getId() == newCTHD.getId()){
                    ds.set(i,newCTHD);
                }
            }
        }
        public HDCT findByID(int id){
            for (int i = 0; i < ds.size(); i++) {
                HDCT cthd = ds.get(i);
                if(cthd.getId() == id){
                    return cthd;
                }
            }
            return null;
        }
}
