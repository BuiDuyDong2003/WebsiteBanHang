package com.example.demo.controller;

import com.example.demo.entity.NhaSanXuat;
import com.example.demo.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("/nha-san-xuat/hien-thi")
    public String hienThiNSX(Model model) {
        model.addAttribute("listNSX", nhaSanXuatService.getAllNSX());
        nhaSanXuatService.getAllNSX();
        return "/viewnsx/nsx";
    }

    @GetMapping("/nha-san-xuat/detail/{id}")
    public String detailNSX(@PathVariable("id") String id, Model model) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getByIdNSX(UUID.fromString(id));
        model.addAttribute("nsx", nhaSanXuat);
        model.addAttribute("listNSX", nhaSanXuatService.getAllNSX());
        nhaSanXuatService.getAllNSX();
        return "/viewnsx/nsx";
    }

    @GetMapping("/nha-san-xuat/remove/{id}")
    public String removeNSX(@PathVariable("id") String id) {
        nhaSanXuatService.deleteNSX(UUID.fromString(id));
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("/nha-san-xuat/add")
    public String addNSX(@RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        NhaSanXuat nsx = NhaSanXuat.builder()
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.addNSX(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("/nha-san-xuat/update")
    public String updateNSX(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        NhaSanXuat nsx = NhaSanXuat.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.updateNSX(nsx);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/nha-san-xuat/view-update/{id}")
    public String viewUpdateSanPham(@PathVariable("id") String id, Model model) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getByIdNSX(UUID.fromString(id));
        model.addAttribute("nsx", nhaSanXuat);
        return "/viewnsx/update";
    }
}
