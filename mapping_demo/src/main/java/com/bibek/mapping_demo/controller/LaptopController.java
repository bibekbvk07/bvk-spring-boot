package com.bibek.mapping_demo.controller;

import com.bibek.mapping_demo.entity.Laptop;
import com.bibek.mapping_demo.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bvk/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops(){
        List<Laptop> laptopList = laptopService.findAllLaptops();
        if (laptopList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(laptopList);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable int id){
        Laptop laptop = laptopService.findById(id);
        if (laptop == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptop);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Laptop> getLaptopByStudentFirstName(@PathVariable String firstName){
        Laptop laptop = laptopService.findLaptopByStudentFirstName(firstName);
        if (laptop == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptop);
    }

    @PostMapping
    public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop){
        if (laptop == null){
            return ResponseEntity.badRequest().build();
        }
        laptop.setLaptopId(0);
        laptopService.save(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(laptop);
    }

    @PutMapping
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop){
        if (laptop == null){
            return ResponseEntity.badRequest().build();
        }
        laptopService.save(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).body(laptop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        laptopService.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }

}
