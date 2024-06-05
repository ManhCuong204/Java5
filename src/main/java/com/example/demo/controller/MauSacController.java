package com.example.demo.controller;

import com.example.demo.entites.MauSac;
import com.example.demo.entites.SanPham;
import com.example.demo.repository.assignment1.MauSacRepository;
import com.example.demo.repository.assignment2.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
   @Autowired
   private MauSacRepo msRepo;
    @GetMapping("create")
    public String create(){
        return "mau_sac/create";
    }
    @PostMapping("store")
    public String store(MauSac ms){
        this.msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }
    @GetMapping("index")
    public String index(Model model){
        List<MauSac> ds =  this.msRepo.findAll();
        model.addAttribute("ds", ds);
        return "mau_sac/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.msRepo.deleteById(id);
        return "redirect:/mau-sac/index";
    }

//    @GetMapping("edit/{id}")
//    public String edit(@PathVariable("id") Integer id,Model model){
//        MauSac ms = this.msRepo.findById(id);
//        model.addAttribute("ds",ms);
//        return "mau_sac/edit";
//    }
//    @PostMapping("update/{id}")
//    public String update(MauSac ms){
//        this.msRepo.update(ms);
//        return "redirect:/mau-sac/index";
//    }
}
