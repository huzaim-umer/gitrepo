package com.morelllcrm.repositories;

import com.morelllcrm.entities.PasswordHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PasswordRespository extends CrudRepository<PasswordHistory, UUID> {


   // PasswordHistory findPasswordHistoriesByUser_id(UUID id);
    PasswordHistory findPasswordHistoriesByUpdatedBy(String email);

//    Passwords findPasswordObjectByEmail(String email);

}
