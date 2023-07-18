package com.example.demo.service.impl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAllCuaHang() {
        return cuaHangRepository.findAll();
    }

    @Override
    public void addCH(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void updateCH(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void deleteCH(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang getByIdCH(UUID id) {
        return cuaHangRepository.findById(id).orElse(null);
    }
}
