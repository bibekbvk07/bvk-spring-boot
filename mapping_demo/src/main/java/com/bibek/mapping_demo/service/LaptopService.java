package com.bibek.mapping_demo.service;

import com.bibek.mapping_demo.entity.Laptop;
import com.bibek.mapping_demo.exceptions.LaptopNotFoundException;
import com.bibek.mapping_demo.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private static final Logger logger = LoggerFactory.getLogger(LaptopService.class);

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public Laptop findLaptopByStudentFirstName(String firstName){
        Laptop laptop = laptopRepository.findLaptopByStudentFirstName(firstName);

        if (laptop == null){
            // Logs the error on the terminal only
            logger.error("Laptop not found for student: {}", firstName);
            throw new LaptopNotFoundException("Laptop not found for the given Student!");
        }
       return laptop;
    }

    public List<Laptop> findAllLaptops(){
        List<Laptop> laptopList = laptopRepository.findAll();
        if (laptopList.isEmpty()){
            throw new LaptopNotFoundException("Laptop not found -> Empty List");
        }
        return laptopList;
    }

    public Laptop findById(int id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isEmpty()){
            logger.error("Laptop not found for: {}", id);
            throw new LaptopNotFoundException("Laptop not found for the given Id.");
        }
        return laptop.get();
    }

    public void save(Laptop laptop){
        if (laptop == null){
            throw new LaptopNotFoundException("Laptop Object was (Null/Empty)!");
        }
        laptopRepository.save(laptop);
    }

    public void deleteById(int id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isEmpty()){
            logger.error("Laptop not found for: {}", id);
            throw new LaptopNotFoundException("Laptop not found for the given Id.");
        }
        laptopRepository.delete(laptop.get());
    }
}
