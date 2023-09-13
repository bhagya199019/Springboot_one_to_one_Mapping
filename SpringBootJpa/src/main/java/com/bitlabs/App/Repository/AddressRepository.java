package com.bitlabs.App.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bitlabs.App.Entity.Address;

public interface AddressRepository extends CrudRepository<Address,Long>{

}
