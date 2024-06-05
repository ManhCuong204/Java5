package com.example.demo.controller;

import com.example.demo.entites.HoaDon;
import com.example.demo.entites.SanPham;
import com.example.demo.repository.assignment1.HoaDonRepository;
import com.example.demo.repository.assignment1.KhachHangRepository;
import com.example.demo.repository.assignment1.NhanVienRepository;
import com.example.demo.repository.assignment2.HoaDonRePo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonRePo hdRepo ;
    private KhachHangRepository khRepo = new KhachHangRepository();
    private NhanVienRepository nvRepo = new NhanVienRepository();

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size,
                        @RequestParam(defaultValue = "") String keyword,
                        HttpSession ses) {
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        List<HoaDon> sanPhamPage = hdRepo.findAll().stream().skip((page-1)*size).limit(size).collect(Collectors.toList());
        model.addAttribute("ds",sanPhamPage);
        int totalpage=1;
        if(hdRepo.findAll().size()%size==0){
            totalpage=hdRepo.findAll().size()/size;
        } else {
            totalpage= hdRepo.findAll().size()/size+1;
        }
        System.out.println(totalpage);
        model.addAttribute("totalPages",totalpage);
        return "hoa_don/index";
    }

    @GetMapping("create")
    public String create(Model model,HttpSession ses){
        if (ses.getAttribute("tentk") == null) {
            ses.setAttribute("errorDN", "Bạn cần đăng nhập để thực hiện chức năng");
            return "redirect:/hoa-don/index";
        }
        model.addAttribute("listKH",khRepo.findAll());
        model.addAttribute("listNV",nvRepo.findAll());
        return "hoa_don/create";
    }
//    @PostMapping("store")
//    public String store(@Valid HoaDon hd, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            Map<String,String> errors = new HashMap<>();
//            for (FieldError e : bindingResult.getFieldErrors()){
//                errors.put(e.getField(),e.getDefaultMessage());
//            }
//            model.addAttribute("errors",errors);
//            model.addAttribute("hd",hd);
//            model.addAttribute("listKH",khRepo.findAll());
//            model.addAttribute("listNV",nvRepo.findAll());
//            return "hoa_don/create";
//        }
//        hdRepo.create(hd);
//        model.addAttribute("ds",hdRepo.findAll());
//        return "redirect:/hoa-don/index";
//    }
//    @GetMapping("delete/{id}")
//    public String delete(@PathVariable("id") Integer id, Model model){
//        hdRepo.deleteByID(id);
//        model.addAttribute("ds",hdRepo.findAll());
//        return "redirect:/hoa-don/index";
//    }
//    @GetMapping("edit/{id}")
//    public String edit(@PathVariable("id") Integer id,Model model,HttpSession ses){
//        if (ses.getAttribute("tentk") == null) {
//            ses.setAttribute("errorDN", "Bạn cần đăng nhập để thực hiện chức năng");
//            return "redirect:/hoa-don/index";
//        }
//        model.addAttribute("hd",hdRepo.findByID(id));
//        model.addAttribute("listKH",khRepo.findAll());
//        model.addAttribute("listNV",nvRepo.findAll());
//        return "hoa_don/edit";
//    }
//    @PostMapping ("update/{id}")
//    public String update(@Valid HoaDon hd,BindingResult bindingResult,Model model){
//        if(bindingResult.hasErrors()){
//            Map<String,String> errors = new HashMap<>();
//            for (FieldError e : bindingResult.getFieldErrors()){
//                errors.put(e.getField(),e.getDefaultMessage());
//            }
//            model.addAttribute("errors",errors);
//            model.addAttribute("hd",hd);
//            model.addAttribute("listKH",khRepo.findAll());
//            model.addAttribute("listNV",nvRepo.findAll());
//            return "hoa_don/edit";
//        }
//        hdRepo.update(hd);
//        return "redirect:/hoa-don/index";



}






