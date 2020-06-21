package com.saan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saan.entity.Laptop;
import com.saan.service.LaptopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/laptop")
@Api(value = "laptop Management System", description = "Operations pertaining to employee in laptop Management ")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/{laptopCode}")
    @ApiOperation(value = "Get an laptop by Id")
    public ResponseEntity<Laptop> findLaptopByLaptopCode(@PathVariable("laptopCode") String laptopCode) {

        Laptop _laptop = laptopService.findLaptopByLaptopCode(laptopCode);
        if (_laptop != null)
            return new ResponseEntity<>(_laptop, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "View a list of available laptop", response = List.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping
    public ResponseEntity<List<Laptop>> findEmployees() {
        try {
            var findAll = laptopService.findAll();
            if (findAll.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(findAll, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Add an laptop")
    @PostMapping
    public ResponseEntity<Laptop> saveEmployee(@RequestBody Laptop laptop) {
        try {
            var _laptop = laptopService.save(laptop);
            return new ResponseEntity<>(_laptop, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
