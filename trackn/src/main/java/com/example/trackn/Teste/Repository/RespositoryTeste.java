package com.example.trackn.Teste.Repository;

import com.example.trackn.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RespositoryTeste extends JpaRepository<Model,Long> {

    List<String> findByCep(Object obj);
}
