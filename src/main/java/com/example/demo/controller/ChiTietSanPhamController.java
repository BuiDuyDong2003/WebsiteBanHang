package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.DongSanPhamService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NhaSanXuatService;
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
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSanPhamService dongSanPhamService;
    @Autowired
    private NhaSanXuatService nhaSanXuatService;


    @GetMapping("/chi-tiet-san-pham/hien-thi")
    public String hienThiCTSP(Model model) {
        model.addAttribute("listCTSP", chiTietSanPhamService.getAllCTSP());
        model.addAttribute("listMS", mauSacService.getAllMauSac());
        model.addAttribute("listSP", sanPhamService.getAllSanPham());
        model.addAttribute("listNSX", nhaSanXuatService.getAllNSX());
        model.addAttribute("listDSP", dongSanPhamService.getAllDongSP());
        chiTietSanPhamService.getAllCTSP();
        return "/viewctsp/ctsp";
    }

    @GetMapping("/chi-tiet-san-pham/detail/{id}")
    public String detailCTSP(@PathVariable("id") String id, Model model) {
        ChiTietSanPham chiTietSP = chiTietSanPhamService.getByIdCTSP(UUID.fromString(id));
        model.addAttribute("ctsp", chiTietSP);
        model.addAttribute("listCTSP", chiTietSanPhamService.getAllCTSP());
        model.addAttribute("listMS", mauSacService.getAllMauSac());
        model.addAttribute("listSP", sanPhamService.getAllSanPham());
        model.addAttribute("listNSX", nhaSanXuatService.getAllNSX());
        model.addAttribute("listDSP", dongSanPhamService.getAllDongSP());
        chiTietSanPhamService.getAllCTSP();
        return "/viewctsp/ctsp";
    }

    @GetMapping("/chi-tiet-san-pham/remove/{id}")
    public String removeCTSP(@PathVariable("id") String id) {
        chiTietSanPhamService.deleteCTSP(UUID.fromString(id));
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/chi-tiet-san-pham/view-update/{id}")
    public String updateCTSP(@PathVariable("id") String id, Model model) {
        ChiTietSanPham chiTietSP = chiTietSanPhamService.getByIdCTSP(UUID.fromString(id));
        model.addAttribute("ctsp", chiTietSP);
        model.addAttribute("listCTSP", chiTietSanPhamService.getAllCTSP());
        model.addAttribute("listMS", mauSacService.getAllMauSac());
        model.addAttribute("listSP", sanPhamService.getAllSanPham());
        model.addAttribute("listNSX", nhaSanXuatService.getAllNSX());
        model.addAttribute("listDSP", dongSanPhamService.getAllDongSP());
        return "/viewctsp/update";
    }

    @PostMapping("/chi-tiet-san-pham/add")
    public String addKH(@RequestParam("sanPham") String sanPham, @RequestParam("dongSP") String dongSP,
                        @RequestParam("mauSac") String mauSac, @RequestParam("nhaSanXuat") String nhaSanXuat,
                        @RequestParam("namBH") String namBH, @RequestParam("moTa") String moTa,
                        @RequestParam("soLuong") Integer soLuong, @RequestParam("giaNhap") Double giaNhap,
                        @RequestParam("giaBan") Double giaBan) {
        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .sanPham(sanPhamService.getByIdSanPham(UUID.fromString(sanPham)))
                .mauSac(mauSacService.getByIdMS(UUID.fromString(mauSac)))
                .dongSP(dongSanPhamService.getByIdDongSP(UUID.fromString(dongSP)))
                .nhaSanXuat(nhaSanXuatService.getByIdNSX(UUID.fromString(nhaSanXuat)))
                .namBH(Integer.valueOf(namBH))
                .moTa(moTa)
                .soLuong(Integer.valueOf(soLuong))
                .giaNhap(Double.valueOf(giaNhap))
                .giaBan(Double.valueOf(giaBan))
                .build();
        chiTietSanPhamService.addCTSP(ctsp);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @PostMapping("/chi-tiet-san-pham/update")
    public String updateKH(@RequestParam("sanPham") String sanPham, @RequestParam("dongSP") String dongSP,
                        @RequestParam("mauSac") String mauSac, @RequestParam("nhaSanXuat") String nhaSanXuat,
                        @RequestParam("namBH") String namBH, @RequestParam("moTa") String moTa,
                        @RequestParam("soLuong") Integer soLuong, @RequestParam("giaNhap") Double giaNhap,
                        @RequestParam("giaBan") Double giaBan, @RequestParam("id") String id) {
        ChiTietSanPham ctsp = ChiTietSanPham.builder()
                .id(UUID.fromString(id))
                .sanPham(sanPhamService.getByIdSanPham(UUID.fromString(sanPham)))
                .mauSac(mauSacService.getByIdMS(UUID.fromString(mauSac)))
                .dongSP(dongSanPhamService.getByIdDongSP(UUID.fromString(dongSP)))
                .nhaSanXuat(nhaSanXuatService.getByIdNSX(UUID.fromString(nhaSanXuat)))
                .namBH(Integer.valueOf(namBH))
                .moTa(moTa)
                .soLuong(Integer.valueOf(soLuong))
                .giaNhap(Double.valueOf(giaNhap))
                .giaBan(Double.valueOf(giaBan))
                .build();
        chiTietSanPhamService.updateCTSP(ctsp);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }


}
