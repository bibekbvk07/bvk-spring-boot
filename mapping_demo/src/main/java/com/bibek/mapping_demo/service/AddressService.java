package com.bibek.mapping_demo.service;

import com.bibek.mapping_demo.entity.Address;
import com.bibek.mapping_demo.exceptions.AddressNotFoundException;
import com.bibek.mapping_demo.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddresses(){
        List<Address> addressList = addressRepository.findAll();
        if (addressList.isEmpty()){
            throw new AddressNotFoundException("Address list was empty");
        }
        return addressList;
    }

    public Address findById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            logger.error("Address not found for {}", id);
            throw new AddressNotFoundException("Address not found for the given Id");
        }
        return address.get();
    }

    public void save(Address address) {
        if (address == null){
            throw new AddressNotFoundException("Address object was null!");
        }
        addressRepository.save(address);
    }

    public void deleteById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()){
            logger.error("Address was not found for: {}", id);
            throw new AddressNotFoundException("Address not found for the given Id");
        }
        addressRepository.delete(address.get());
    }
}
