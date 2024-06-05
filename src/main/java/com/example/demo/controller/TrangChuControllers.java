package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TrangChuControllers {
    @GetMapping("trang-chu")
    public String trangchu(HttpSession session,Model model){
        model.addAttribute("user", session.getAttribute("user"));
        return "trang_chu/index";
    }
}
