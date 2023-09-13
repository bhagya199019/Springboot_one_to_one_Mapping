package com.bitlabs.App.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bitlabs.App.Entity.User;

public interface UserRepository extends CrudRepository<User,Long>{

}
