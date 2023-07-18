package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public void addKH(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void updateKH(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKH(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang getByIdKH(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }
}
