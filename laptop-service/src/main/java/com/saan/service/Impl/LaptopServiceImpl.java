package com.saan.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saan.entity.Laptop;
import com.saan.repository.LaptopRepository;
import com.saan.service.LaptopService;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Laptop findLaptopByLaptopCode(String laptopCode) {
        return laptopRepository.findLaptopByLaptopCode(laptopCode);
    }

    @Override
    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

}
