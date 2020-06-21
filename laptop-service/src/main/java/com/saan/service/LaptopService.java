package com.saan.service;

import java.util.List;

import com.saan.entity.Laptop;

public interface LaptopService {

    public Laptop findLaptopByLaptopCode(String laptopCode);

    public Laptop save(Laptop laptop);

    public List<Laptop> findAll();

}
