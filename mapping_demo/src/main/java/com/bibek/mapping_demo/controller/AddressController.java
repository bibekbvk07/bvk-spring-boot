package com.bibek.mapping_demo.controller;

import com.bibek.mapping_demo.entity.Address;
import com.bibek.mapping_demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bvk/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> addressList = addressService.findAllAddresses();
        if (addressList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(addressList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id){
        Address address = addressService.findById(id);
        if (address == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        if (address == null){
            return ResponseEntity.badRequest().build();
        }
        address.setAddressId(0); // if the user provides the addressId in the json body
        addressService.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        if (address == null){
            return ResponseEntity.badRequest().build();
        }
        addressService.save(address);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(address);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        Address address = addressService.findById(id);
        if (address == null){
            return ResponseEntity.notFound().build();
        }
        addressService.deleteById(id);
        return ResponseEntity.ok("Address for the given Id was deleted ->");
    }
}
