package com.example.demo.controller;

import com.example.demo.entites.KichThuoc;
import com.example.demo.entites.MauSac;
import com.example.demo.repository.assignment1.KichThuocRepository;
import com.example.demo.repository.assignment2.KichThuocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepo ktRepo;
    @GetMapping("create")
    public String create(){
        return "kich_thuoc/create";
    }
    @PostMapping("store")
    public String store(KichThuoc kt){
        this.ktRepo.save(kt);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("index")
    public String index(Model model){
        List<KichThuoc> ds =  this.ktRepo.findAll();
        model.addAttribute("ds", ds);
        return "kich_thuoc/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }
//    @GetMapping("edit/{id}")
//    public String edit(@PathVariable("id") Integer id, Model model){
//        KichThuoc kt = this.ktRepo.findById(id);
//        model.addAttribute("ds",kt);
//        return "kich_thuoc/edit";
//    }
//    @PostMapping("update/{id}")
//    public String update(KichThuoc kt){
//        this.ktRepo.update(kt);
//        return "redirect:/kich-thuoc/index";
//    }

}