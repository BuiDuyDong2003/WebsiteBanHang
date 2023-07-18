package com.example.demo.service;

import com.example.demo.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAllMauSac();

    void addMS(MauSac mauSac);

    void upadteMS(MauSac mauSac);

    void deleteMS(UUID id);

    MauSac getByIdMS(UUID id);
}
