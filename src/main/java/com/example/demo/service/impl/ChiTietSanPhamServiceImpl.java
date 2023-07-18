package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAllCTSP() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public void addCTSP(ChiTietSanPham chiTietSP) {
        chiTietSanPhamRepository.save(chiTietSP);
    }

    @Override
    public void updateCTSP(ChiTietSanPham chiTietSP) {
        chiTietSanPhamRepository.save(chiTietSP);
    }

    @Override
    public void deleteCTSP(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public ChiTietSanPham getByIdCTSP(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }
}
