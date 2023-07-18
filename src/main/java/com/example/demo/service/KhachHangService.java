package com.example.demo.service;

import com.example.demo.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAllKhachHang();

    void addKH(KhachHang khachHang);

    void updateKH(KhachHang khachHang);

    void deleteKH(UUID id);

    KhachHang getByIdKH(UUID id);
}
