package com.example.demo.service.impl;

import com.example.demo.entity.DongSanPham;
import com.example.demo.repository.DongSanPhamRepository;
import com.example.demo.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAllDongSP() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public void addDongSP(DongSanPham dongSP) {
        dongSanPhamRepository.save(dongSP);
    }

    @Override
    public void updateDongSP(DongSanPham dongSP) {
        dongSanPhamRepository.save(dongSP);
    }

    @Override
    public void deleteDongSP(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }

    @Override
    public DongSanPham getByIdDongSP(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }
}
