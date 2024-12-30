package br.com.uni.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uni.app.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
