package com.example.demo.configs;

import com.example.demo.entites.SanPham;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfigs {
    @Bean(name = "bean1")
    public SanPham getSPBean1(){
        SanPham sp = new SanPham(1,"SP001","Linh",1);
        return sp;
    }

    @Bean(name = "bean2")
    public SanPham getSPBean2(){
        SanPham sp = new SanPham(2,"SP002","Linhmm",0);
        return sp;
    }
}
