package com.example.demo.controller;


import com.example.demo.entites.KhachHang;
import com.example.demo.entites.SanPham;
import com.example.demo.repository.assignment1.KhachHangRepository;
import com.example.demo.repository.assignment2.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
@Autowired
private KhachHangRepo khRepo;
@GetMapping("create")
    public String create(){
    return "khach_hang/create";
}
@PostMapping("store")
public String store(KhachHang kh){
    this.khRepo.save(kh);
    return "redirect:/khach-hang/index";
}
@GetMapping("index")
public String index(Model model){
    List<KhachHang> ds = this.khRepo.findAll();
    model.addAttribute("ds",ds);
    return "khach_hang/index";
}
@GetMapping("delete/{id}")
public String delete(@PathVariable("id") Integer id){
    this.khRepo.deleteById(id);
    return "redirect:/khach-hang/index";
}
    @GetMapping("edit/{id}")
    public String viewupdate(Model model,@PathVariable("id")Integer id){
        Optional<KhachHang> list= khRepo.findById(id);
        if (list.isPresent()){
            model.addAttribute("kh",list.get());
        }
        return "khach_hang/edit";
    }
    @PostMapping("update/{id}")
    public String Update(KhachHang kh){
        this.khRepo.save(kh);
        return "redirect:/khach-hang/index";
    }
}
