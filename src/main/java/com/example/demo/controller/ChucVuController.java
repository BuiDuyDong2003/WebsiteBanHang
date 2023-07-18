package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/chuc-vu/hien-thi")
    public String hienThiChucVu(Model model){
        model.addAttribute("listCV", chucVuService.getAllChucVu());
        chucVuService.getAllChucVu();
        return "/viewcv/chucvu";
    }

    @GetMapping("/chuc-vu/detail/{id}")
    public String detailCV(@PathVariable("id") String id, Model model){
        ChucVu chucVu = chucVuService.getByIdCV(UUID.fromString(id));
        model.addAttribute("cv", chucVu);
        model.addAttribute("listCV", chucVuService.getAllChucVu());
        chucVuService.getAllChucVu();
        return "/viewcv/chucvu";
    }

    @GetMapping("/chuc-vu/remove/{id}")
    public String removeCV(@PathVariable("id") String id){
        chucVuService.deleteCV(UUID.fromString(id));
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/chuc-vu/add")
    public String addChucVu(@RequestParam("ma") String ma, @RequestParam("ten") String ten){
        ChucVu cv = ChucVu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.addCV(cv);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/chuc-vu/update")
    public String updateChucVu(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten){
        ChucVu cv = ChucVu.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.updateCV(cv);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/chuc-vu/view-update/{id}")
    public String viewUpdateChucVu(@PathVariable("id") String id, Model model){
        ChucVu chucVu = chucVuService.getByIdCV(UUID.fromString(id));
        model.addAttribute("cv", chucVu);
        return "/viewcv/update";
    }
}
