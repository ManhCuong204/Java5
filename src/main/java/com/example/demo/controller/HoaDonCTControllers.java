package com.example.demo.controller;


import com.example.demo.entites.HDCT;
import com.example.demo.repository.assignment1.HDCTRepo;
import com.example.demo.repository.assignment1.HoaDonRepository;
import com.example.demo.repository.assignment1.SPCTRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("ct-hoa-don")
public class HoaDonCTControllers {
    private HDCTRepo cthdRepo = new HDCTRepo();
    private HoaDonRepository hdRepo = new HoaDonRepository();
    private SPCTRepository ctspRepo = new SPCTRepository();

    @GetMapping("index")
    public String index(Model model, @RequestParam(required = false) Integer idHD){
        model.addAttribute("listHD", hdRepo.findAll());
        if (idHD != null) {
            model.addAttribute("listCTHD", cthdRepo.findByidHD(idHD));
        } else {
            model.addAttribute("listCTHD", new ArrayList<>());
        }
        return "hd_ct/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model, HttpSession ses){
        if (ses.getAttribute("tentk") == null) {
            ses.setAttribute("errorDN", "Bạn cần đăng nhập để thực hiện chức năng");
            return "redirect:/ct-hoa-don/index";
        }
        model.addAttribute("cthd",cthdRepo.findByID(id));
        model.addAttribute("listCTSP",ctspRepo.findAll());
        return "hd_ct/edit";
    }
    @PostMapping("update/{id}")
    public String update(@Valid HDCT cthd, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e : bindingResult.getFieldErrors()){
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("ds",cthd);
            return "hd_ct/edit";
        }
        cthdRepo.update(cthd);
        return "redirect:/ct-hoa-don/index";
    }
}

