package com.example.demo.controller;


import com.example.demo.entites.NhanVien;
import com.example.demo.entites.SanPham;
import com.example.demo.repository.assignment1.SanPhamReponew;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("san-pham")
@Controller
public class SanPhamController {
    @Autowired
    private SanPhamReponew spRepo ;
//them
    @GetMapping("create")
    public String create(@ModelAttribute("ds") SanPham sp)  {
        return "san_pham/create";
    }

    @PostMapping("store")
    public  String store
            ( Model model ,@Valid SanPham sp, BindingResult validateResult)
    {
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for(FieldError e: listFieldError){
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("ds", sp);
            return "san_pham/create";
        }
       this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }
//phan index hien thi
    @GetMapping("index")
    public String index(Model model, @RequestParam(defaultValue =  "1") int page,@RequestParam(defaultValue = "10") int  limit,
                        @RequestParam(value = "nameormasp",required = false) String nameormasp,
                        @RequestParam(value = "trangThai",required = false) Integer trangThai){
        Pageable pageable= PageRequest.of(page-1,limit);
       Page<SanPham> sanPhamPage= spRepo.findAll(pageable);
//        spRepo.findSanPhamByNameOrByMaAndTrangThai(nameormasp==null?null:nameormasp.trim(),trangThai==null?null:trangThai,pageable);
        model.addAttribute("totalPage",sanPhamPage.getTotalPages());
        model.addAttribute("nameormasp",nameormasp);
        model.addAttribute("trangThai",trangThai);
        model.addAttribute("sp",sanPhamPage);
        model.addAttribute("currentPage",page);

        return "san_pham/index";
    }
    @GetMapping("edit/{id}")
    public String viewupdate(Model model,@PathVariable("id")Integer id){
        Optional<SanPham> list= spRepo.findById(id);
        if (list.isPresent()){
            model.addAttribute("sp",list.get());
        }
        return "san_pham/edit";
    }
    @PostMapping("update/{id}")
    public String Update(SanPham sp){
        this.spRepo.save(sp);
        return "redirect:/san-pham/index";
    }

}