package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThiNV(Model model) {
        model.addAttribute("listNV", nhanVienService.getAllNhanVien());
        model.addAttribute("listCH", cuaHangService.getAllCuaHang());
        model.addAttribute("listCV", chucVuService.getAllChucVu());
        nhanVienService.getAllNhanVien();
        return "viewnv/nhanvien";
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public String detailNV(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getByIdNV(UUID.fromString(id));
        model.addAttribute("nv", nhanVien);
        model.addAttribute("listNV", nhanVienService.getAllNhanVien());
        model.addAttribute("listCH", cuaHangService.getAllCuaHang());
        model.addAttribute("listCV", chucVuService.getAllChucVu());
        nhanVienService.getAllNhanVien();
        return "viewnv/nhanvien";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String removeNV(@PathVariable("id") String id) {
        nhanVienService.deleteNV(UUID.fromString(id));
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/view-update/{id}")
    public String viewUpdateNV(@PathVariable("id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.getByIdNV(UUID.fromString(id));
        model.addAttribute("nv", nhanVien);
        model.addAttribute("listNV", nhanVienService.getAllNhanVien());
        model.addAttribute("listCH", cuaHangService.getAllCuaHang());
        model.addAttribute("listCV", chucVuService.getAllChucVu());
        return "/viewnv/update";
    }

    @PostMapping("/nhan-vien/add")
    public String addKH(@RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("ho") String ho,
                        @RequestParam("tenDem") String tenDem, @RequestParam("ngaySinh") String ngaySinh,
                        @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi,
                        @RequestParam("gioiTinh") String gioiTinh, @RequestParam("cuaHang") String cuaHang,
                        @RequestParam("chucVu") String chucVu, @RequestParam("matKhau") String matKhau,
                        @RequestParam("trangThai") Integer trangThai) {
        NhanVien nhanVien = NhanVien.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .gioiTinh(gioiTinh)
                .chucVu(chucVuService.getByIdCV(UUID.fromString(chucVu)))
                .cuaHang(cuaHangService.getByIdCH(UUID.fromString(cuaHang)))
                .matKhau(matKhau)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.addNV(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/nhan-vien/update")
    public String updateKH(@RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("ho") String ho,
                           @RequestParam("tenDem") String tenDem, @RequestParam("ngaySinh") String ngaySinh,
                           @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi,
                           @RequestParam("gioiTinh") String gioiTinh, @RequestParam("cuaHang") String cuaHang,
                           @RequestParam("chucVu") String chucVu, @RequestParam("matKhau") String matKhau,
                           @RequestParam("trangThai") Integer trangThai, @RequestParam("id") String id) {
        NhanVien nhanVien = NhanVien.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .gioiTinh(gioiTinh)
                .chucVu(chucVuService.getByIdCV(UUID.fromString(chucVu)))
                .cuaHang(cuaHangService.getByIdCH(UUID.fromString(cuaHang)))
                .matKhau(matKhau)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        nhanVienService.updateNV(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
