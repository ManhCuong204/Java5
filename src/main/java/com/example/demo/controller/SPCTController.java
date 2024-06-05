package com.example.demo.controller;

import com.example.demo.entites.SPCT;
import com.example.demo.entites.SanPham;
import com.example.demo.repository.assignment1.SanPhamReponew;

import com.example.demo.repository.assignment2.SanPhamCTRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ct-san-pham")
public class SPCTController {
    @Autowired
    private SanPhamCTRepo spctrp;
    @Autowired
    private SanPhamReponew spr;
//    private KichThuocRepository ktRepo = new KichThuocRepository();
//    private MauSacRepository msRepo = new MauSacRepository();


    @GetMapping("index")
    public String index(Model model, @RequestParam(required = false) Integer idSP){
        getIDSP = String.valueOf(idSP);
        model.addAttribute("listSP",spr.findAll()); // Cbo box
        if(idSP != null){
            model.addAttribute("listCTSP",spctrp.findAllByIdSP(idSP));
            System.out.println(spctrp.findAllByIdSP(idSP).size());
        }else {
            model.addAttribute("listCTSP",spctrp.findAllByIdSP(idSP));
        }
        return "sp_ct/index";
    }
    public static String getIDSP = "";
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("idSP" ,getIDSP);
//        model.addAttribute("listMS", msRepo.findAll());
//        model.addAttribute("listKT", ktRepo.findAll());
        return "sp_ct/create";
    }

    @PostMapping("store")
    public String store(@Valid SPCT ctsp, BindingResult bindingResult, Model model){
        model.addAttribute("idSP",getIDSP);
        if(bindingResult.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for (FieldError e : bindingResult.getFieldErrors()){
                errors.put(e.getField(),e.getDefaultMessage());
            }

            model.addAttribute("errors",errors);
            model.addAttribute("ctsp",ctsp);
            return "sp_ct/create";
        }

        spctrp.save(ctsp);
        return "redirect:/ct-san-pham/index";
    }
//    @GetMapping("delete/{id}")
//    public String delete(@PathVariable("id") Integer id, Model model){
////        ctspRepo.deleteByID(id);
//        spr.deleteAllById(id);
//        return "redirect:/ct-san-pham/index";
////    }
//    @GetMapping("edit/{id}")
//    public String edit(@PathVariable("id") Integer id,Model model){
//        model.addAttribute("ctsp",spr.findAllById(id));
//        model.addAttribute("listMS", msRepo.findAll());
//        model.addAttribute("listKT", ktRepo.findAll());
//        return "sp_ct/edit";
//    }
//    @PostMapping ("update/{id}")
//    public String update(@Valid SPCT ctsp,BindingResult bindingResult,Model model){
//        if(bindingResult.hasErrors()){
//            Map<String,String> errors = new HashMap<>();
//            for (FieldError e : bindingResult.getFieldErrors()){
//                errors.put(e.getField(),e.getDefaultMessage());
//            }
//            model.addAttribute("errors",errors);
//            model.addAttribute("ctsp",ctsp);
//            return "sp_ct/edit";
//        }
//        spr.
//        return "redirect:/ct-san-pham/index";
//    }

}


