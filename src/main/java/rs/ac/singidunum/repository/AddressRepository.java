package rs.ac.singidunum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
