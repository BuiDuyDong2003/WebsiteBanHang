package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/cua-hang/hien-thi")
    public String hienThiCuaHang(Model model) {
        model.addAttribute("listCH", cuaHangService.getAllCuaHang());
        cuaHangService.getAllCuaHang();
        return "/viewch/cuahang";
    }

    @GetMapping("/cua-hang/detail/{id}")
    public String detailCH(@PathVariable("id") String id, Model model) {
        CuaHang cuaHang = cuaHangService.getByIdCH(UUID.fromString(id));
        model.addAttribute("ch", cuaHang);
        model.addAttribute("listCH", cuaHangService.getAllCuaHang());
        cuaHangService.getAllCuaHang();
        return "/viewch/cuahang";
    }

    @GetMapping("/cua-hang/remove/{id}")
    public String removeCuaHang(@PathVariable("id") String id) {
        cuaHangService.deleteCH(UUID.fromString(id));
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("/cua-hang/add")
    public String addCuaHang(@RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        CuaHang ch = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .build();
        cuaHangService.addCH(ch);
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("/cua-hang/update")
    public String updateCuahang(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        CuaHang ch = CuaHang.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        cuaHangService.updateCH(ch);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/cua-hang/view-update/{id}")
    public String viewUpdateCuaHang(@PathVariable("id") String id, Model model) {
        CuaHang cuaHang = cuaHangService.getByIdCH(UUID.fromString(id));
        model.addAttribute("ch", cuaHang);
        return "/viewch/update";
    }
}


