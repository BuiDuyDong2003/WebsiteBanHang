package com.example.demo.service;

import com.example.demo.entity.DongSanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSanPham> getAllDongSP();

    void addDongSP(DongSanPham dongSP);

    void updateDongSP(DongSanPham dongSP);

    void deleteDongSP(UUID id);

    DongSanPham getByIdDongSP(UUID id);
}
