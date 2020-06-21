package com.saan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saan.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    public Laptop findLaptopByLaptopCode(String laptopCode);

}
