package com.example.demo.service;

import com.example.demo.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAllNhanVien();

    void addNV(NhanVien nhanVien);

    void updateNV(NhanVien nhanVien);

    void deleteNV(UUID id);

    NhanVien getByIdNV(UUID id);

}
