package com.cemal.service;


import com.cemal.repository.ISkorRepository;
import com.cemal.repository.entity.Skor;
import com.cemal.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SkorService extends ServiceManager<Skor,Long> implements Serializable {
   private final ISkorRepository skorRepository;

    public SkorService(ISkorRepository skorRepository) {
        super(skorRepository);
        this.skorRepository = skorRepository;
    }

    public List<Skor> findall(){
        return findall();
    }

    public Skor findbyid(Long id){
        return findbyid(id);
    }

    public List<Skor> sirala(){
        return skorRepository.findAllByOrderBySkorDesc();
    }









}
