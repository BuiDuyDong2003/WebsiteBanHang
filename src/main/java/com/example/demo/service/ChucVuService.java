package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAllChucVu();

    void addCV(ChucVu chucVu);

    void updateCV(ChucVu chucVu);

    void deleteCV(UUID id);

    ChucVu getByIdCV(UUID id);
}
