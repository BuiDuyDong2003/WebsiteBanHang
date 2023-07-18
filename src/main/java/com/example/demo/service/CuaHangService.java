package com.example.demo.service;

import com.example.demo.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAllCuaHang();

    void addCH(CuaHang cuaHang);

    void updateCH(CuaHang cuaHang);

    void deleteCH(UUID id);

    CuaHang getByIdCH(UUID id);
}
