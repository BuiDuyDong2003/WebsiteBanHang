package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/san-pham/hien-thi")
    public String hienThiSanPham(Model model){
        model.addAttribute("listSP", sanPhamService.getAllSanPham());
        sanPhamService.getAllSanPham();
        return "/viewsp/sanpham";
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detailSanPham(@PathVariable("id") String id, Model model){
        SanPham sanPham = sanPhamService.getByIdSanPham(UUID.fromString(id));
        model.addAttribute("sp", sanPham);
        model.addAttribute("listSP", sanPhamService.getAllSanPham());
        sanPhamService.getAllSanPham();
        return "/viewsp/sanpham";
    }

    @GetMapping("/san-pham/remove/{id}")
    public String removeSanPham(@PathVariable("id") String id){
        sanPhamService.deleteSanPham(UUID.fromString(id));
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/add")
    public String addSanPham(@RequestParam("ma") String ma, @RequestParam("ten") String ten){
        SanPham sp = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.addSanPham(sp);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/update")
    public String updateSanPham(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten){
        SanPham sp = SanPham.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.updateSanPham(sp);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdateSanPham(@PathVariable("id") String id, Model model){
        SanPham sanPham = sanPhamService.getByIdSanPham(UUID.fromString(id));
        model.addAttribute("sp", sanPham);
        return "/viewsp/update";
    }

}
