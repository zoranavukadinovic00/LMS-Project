package rs.ac.singidunum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.model.Address;
import rs.ac.singidunum.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findOne(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
    	addressRepository.deleteById(id);
    }

    public void delete(Address address) {
    	addressRepository.delete(address);
    }

}
