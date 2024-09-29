package com.example.TacoCloudApplication.repositoies;

import com.example.TacoCloudApplication.data.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByUsername(String username);
}
