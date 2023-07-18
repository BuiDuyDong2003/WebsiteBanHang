package com.example.demo.service.impl;

import com.example.demo.entity.NhaSanXuat;
import com.example.demo.repository.NhaSanXuatRepository;
import com.example.demo.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSanXuat> getAllNSX() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public void addNSX(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void updateNSX(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void deleteNSX(UUID id) {
        nhaSanXuatRepository.deleteById(id);
    }

    @Override
    public NhaSanXuat getByIdNSX(UUID id) {
        return nhaSanXuatRepository.findById(id).orElse(null);
    }
}
