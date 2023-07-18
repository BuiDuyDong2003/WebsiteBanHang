package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<ChiTietSanPham> getAllCTSP();

    void addCTSP(ChiTietSanPham chiTietSP);

    void updateCTSP(ChiTietSanPham chiTietSP);

    void deleteCTSP(UUID id);

    ChiTietSanPham getByIdCTSP(UUID id);
}
