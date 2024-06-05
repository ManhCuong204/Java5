package com.example.demo.controller;

import com.example.demo.entites.NhanVien;
import com.example.demo.repository.assignment1.NhanVienRepository;
import com.example.demo.repository.assignment2.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepo nvRepo;
    @GetMapping("create")
    public String create(){
        return "nhan_vien/create";
    }
    @PostMapping("store")
    public String store(NhanVien nv){
        this.nvRepo.save(nv);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("index")
    public String index(Model model){
        List<NhanVien> ds = this.nvRepo.findAll();
        model.addAttribute("ds",ds);
        return "nhan_vien/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
//    @GetMapping("edit/{id}")
//    public String edit(@PathVariable("id") Integer id, Model model){
//        NhanVien nv = this.nvRepo.findById(id);
//        model.addAttribute("ds",nv);
//        return "nhan_vien/edit";
//    }
//    @PostMapping ("update/{id}")
//    public String update(NhanVien nv){
//        this.nvRepo.update(nv);
//        return "redirect:/nhan-vien/index";
//    }
}
