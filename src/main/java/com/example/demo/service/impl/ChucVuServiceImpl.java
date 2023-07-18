package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAllChucVu() {
        return chucVuRepository.findAll();
    }

    @Override
    public void addCV(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void updateCV(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void deleteCV(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu getByIdCV(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }
}
