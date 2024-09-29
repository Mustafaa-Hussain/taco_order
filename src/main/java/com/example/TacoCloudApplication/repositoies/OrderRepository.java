package com.example.TacoCloudApplication.repositoies;

import com.example.TacoCloudApplication.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
