package com.duke.core.dao;

import org.springframework.data.repository.CrudRepository;

import com.duke.core.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}