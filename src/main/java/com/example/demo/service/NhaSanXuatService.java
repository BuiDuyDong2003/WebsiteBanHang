package com.example.demo.service;

import com.example.demo.entity.NhaSanXuat;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAllNSX();

    void addNSX(NhaSanXuat nhaSanXuat);

    void updateNSX(NhaSanXuat nhaSanXuat);

    void deleteNSX(UUID id);

    NhaSanXuat getByIdNSX(UUID id);
}
