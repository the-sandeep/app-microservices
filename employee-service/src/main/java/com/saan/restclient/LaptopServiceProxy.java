package com.saan.restclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saan.model.Laptop;

//@FeignClient(name = "laptop-service", url = "localhost:8100/api/v1")
@FeignClient(name = "laptop-service")
@RibbonClient(name = "laptop-service")
public interface LaptopServiceProxy {

    @GetMapping("/api/v1/{laptopCode}")
    public Laptop findLaptopByLaptopCode(@PathVariable("laptopCode") String laptopCode);

}
