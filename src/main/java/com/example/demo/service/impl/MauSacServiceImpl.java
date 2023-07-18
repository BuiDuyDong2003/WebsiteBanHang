package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public void addMS(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void upadteMS(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteMS(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac getByIdMS(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }
}
