package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteSanPham(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham getByIdSanPham(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }
}
