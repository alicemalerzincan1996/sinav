package com.cemal.repository;

import com.cemal.repository.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISehirRepository extends JpaRepository<Sehir,Long> {
    Optional<Sehir> findOptionalByName(String name);
}
