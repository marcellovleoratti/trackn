package com.example.trackn.Repository;

import com.example.trackn.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model,Long> {

    List<String> findByCep(Object obj);



}
