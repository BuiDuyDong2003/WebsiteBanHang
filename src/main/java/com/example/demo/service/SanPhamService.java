package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAllSanPham();

    void addSanPham(SanPham sanPham);

    void updateSanPham(SanPham sanPham);

    void deleteSanPham(UUID id);

    SanPham getByIdSanPham(UUID id);
}
