package com.example.TacoCloudApplication.repositoies;

import com.example.TacoCloudApplication.data.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
}
