package com.morelllcrm.repositories;

import com.morelllcrm.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Long> {


    Users findByEmailId(String email);

    Users getById(long id);

}
