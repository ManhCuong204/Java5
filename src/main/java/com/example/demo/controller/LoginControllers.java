package com.example.demo.controller;

import org.springframework.ui.Model;
import com.example.demo.entites.Login;
import com.example.demo.repository.assignment1.LoginRepo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginControllers {

        private LoginRepo loginRepo= new LoginRepo();
        public List<Login> taikh = new ArrayList<>();

        public LoginControllers(){
            taikh.add(new Login(1, "aaa", "123", 1));
            taikh.add(new Login(2, "bbb", "456", 0));
        }

        @PostMapping("login/formdn")
        public String formdangnhap() {
            return "login/formdn";
        }

        @GetMapping("login/formdn")
        public String formdangnhapG() {
            return "login/formdn";
        }

        @PostMapping("login/dn")
        public String dangnhap(@Valid Login lg , BindingResult bindingResult, HttpSession ses, Model model, @RequestParam(required = false, value = "usern") String usern, @RequestParam(required = false, value = "passw") String passw) {
            if (taikh.size() < 1) {
                model.addAttribute("er", "Chưa có tài khoản nào");
                return "login/formdn";
            } else {
                for (Login login : taikh) {
                    if (usern.equals(login.getUsern()) && passw.equals(login.getPassw())) {
                        ses.setAttribute("tentk", usern);
                        ses.setAttribute("quyentk", login.getPq());
                        model.addAttribute("user", usern);
                        model.addAttribute("quyen", login.getPq());
                        ses.setAttribute("errorDN",null);
                        return "/trang_chu/index";
                    }
                }
            }
            if(bindingResult.hasErrors()){
                Map<String,String> errors = new HashMap<>();
                for (FieldError e : bindingResult.getFieldErrors()){
                    errors.put(e.getField(),e.getDefaultMessage());
                }
                model.addAttribute("errors",errors);
                model.addAttribute("us",lg);
                return "login/formdn";
            }
            model.addAttribute("er", "Tài khoản không đúng");
            return "login/formdn";
        }

//        @PostMapping("login/dk")
//        public String dangky(@Valid User us,BindingResult bindingResult,@RequestParam("usern") String usern, @RequestParam(required = false, value = "passw") String passw, @RequestParam(required = false, value = "quyen") int quyen, Model model) {
//            for (Login login : taikh) {
//                if (usern.equals(login.getUsern())) {
//                    model.addAttribute("er", "Tài khoản đã tồn tại");
//                    return "user/formdk";
//                }
//            }
//            if(bindingResult.hasErrors()){
//                Map<String,String> errors = new HashMap<>();
//                for (FieldError e : bindingResult.getFieldErrors()){
//                    errors.put(e.getField(),e.getDefaultMessage());
//                }
//                model.addAttribute("errors",errors);
//                model.addAttribute("us",us);
//                return "user/formdk";
//            }
//            taikh.add(new Login(null,usern, passw, quyen));
//            return "user/formdn";
//        }
    }

