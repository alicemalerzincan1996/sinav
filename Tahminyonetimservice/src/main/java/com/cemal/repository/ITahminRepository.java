package com.cemal.repository;

import com.cemal.Tahmin;
import com.cemal.repository.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITahminRepository extends JpaRepository<com.cemal.repository.entity.Tahmin,Long> {
    Optional<Tahmin> findOptionalByName(String name);
}
