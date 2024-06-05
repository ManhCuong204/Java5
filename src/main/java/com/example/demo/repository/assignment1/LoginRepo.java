package com.example.demo.repository.assignment1;

import com.example.demo.entites.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginRepo {

        private List<Login> ds = new ArrayList<>();

        public LoginRepo(){
            ds.add(new Login(1,"a","a",1));
        }
        public void create(Login lg){
            lg.setId(ds.size()+1);
            ds.add(lg);
        }
        public List<Login> getAll(){
            return ds;
        }
}
