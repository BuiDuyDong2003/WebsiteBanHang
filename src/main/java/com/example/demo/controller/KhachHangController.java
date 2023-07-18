package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach-hang/hien-thi")
    public String hienThiKH(Model model) {
        model.addAttribute("listKH", khachHangService.getAllKhachHang());
        khachHangService.getAllKhachHang();
        return "/viewkh/khachhang";
    }

    @GetMapping("/khach-hang/detail/{id}")
    public String detailKh(@PathVariable("id") String id, Model model) {
        KhachHang khachHang = khachHangService.getByIdKH(UUID.fromString(id));
        model.addAttribute("kh", khachHang);
        model.addAttribute("listKH", khachHangService.getAllKhachHang());
        khachHangService.getAllKhachHang();
        return "/viewkh/khachhang";
    }

    @GetMapping("/khach-hang/remove/{id}")
    public String removeKH(@PathVariable("id") String id) {
        khachHangService.deleteKH(UUID.fromString(id));
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/khach-hang/add")
    public String addKH(@RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("ho") String ho,
                        @RequestParam("tenDem") String tenDem, @RequestParam("ngaySinh") String ngaySinh,
                        @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi,
                        @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia,
                        @RequestParam("matKhau") String matKhau) {
        KhachHang kh = KhachHang.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.addKH(kh);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/khach-hang/update")
    public String updateKH(@RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("ho") String ho,
                           @RequestParam("tenDem") String tenDem, @RequestParam("ngaySinh") String ngaySinh,
                           @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi,
                           @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia,
                           @RequestParam("matKhau") String matKhau, @RequestParam("id") String id) {
        KhachHang kh = KhachHang.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.addKH(kh);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/view-update/{id}")
    public String viewUpdateKH(@PathVariable("id") String id, Model model) {
        KhachHang khachHang = khachHangService.getByIdKH(UUID.fromString(id));
        model.addAttribute("kh", khachHang);
        return "/viewkh/update";
    }
}
