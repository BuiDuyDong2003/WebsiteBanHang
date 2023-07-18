package com.example.demo.controller;

import com.example.demo.entity.DongSanPham;
import com.example.demo.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;


    @GetMapping("/dong-san-pham/hien-thi")
    public String hienThiDSP(Model model) {
        model.addAttribute("listDSP", dongSanPhamService.getAllDongSP());
       dongSanPhamService.getAllDongSP();
        return "/viewdsp/dongsp";
    }

    @GetMapping("/dong-san-pham/detail/{id}")
    public String detailDSP(@PathVariable("id") String id, Model model) {
        DongSanPham dongSP = dongSanPhamService.getByIdDongSP(UUID.fromString(id));
        model.addAttribute("dsp", dongSP);
        model.addAttribute("listDSP", dongSanPhamService.getAllDongSP());
        dongSanPhamService.getAllDongSP();
        return "/viewdsp/dongsp";
    }

    @GetMapping("/dong-san-pham/remove/{id}")
    public String removeDSP(@PathVariable("id") String id) {
        dongSanPhamService.deleteDongSP(UUID.fromString(id));
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("/dong-san-pham/add")
    public String addDSP(@RequestParam("ma") String ma, @RequestParam("ten") String ten) {
       DongSanPham dsp = DongSanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.addDongSP(dsp);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @PostMapping("/dong-san-pham/update")
    public String updateDSP(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        DongSanPham dsp = DongSanPham.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.addDongSP(dsp);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/dong-san-pham/view-update/{id}")
    public String viewUpdateDSP(@PathVariable("id") String id, Model model) {
        DongSanPham dongSP = dongSanPhamService.getByIdDongSP(UUID.fromString(id));
        model.addAttribute("dsp", dongSP);
        return "/viewdsp/update";
    }
}
