package com.example.demo.controller;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mau-sac/hien-thi")
    public String hienThiMS(Model model) {
        model.addAttribute("listMS", mauSacService.getAllMauSac());
        mauSacService.getAllMauSac();
        return "/viewms/mausac";
    }

    @GetMapping("/mau-sac/detail/{id}")
    public String detailMS(@PathVariable("id") String id, Model model) {
        MauSac mauSac = mauSacService.getByIdMS(UUID.fromString(id));
        model.addAttribute("ms", mauSac);
        model.addAttribute("listMS", mauSacService.getAllMauSac());
        mauSacService.getAllMauSac();
        return "/viewms/mausac";
    }

    @GetMapping("/mau-sac/remove/{id}")
    public String removeMS(@PathVariable("id") String id) {
        mauSacService.deleteMS(UUID.fromString(id));
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/mau-sac/add")
    public String addMS(@RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        MauSac ms = MauSac.builder()
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.addMS(ms);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/mau-sac/update")
    public String updateMS(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        MauSac ms = MauSac.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.upadteMS(ms);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUpdateMS(@PathVariable("id") String id, Model model) {
        MauSac mauSac = mauSacService.getByIdMS(UUID.fromString(id));
        model.addAttribute("ms", mauSac);
        return "/viewms/update";
    }
}
