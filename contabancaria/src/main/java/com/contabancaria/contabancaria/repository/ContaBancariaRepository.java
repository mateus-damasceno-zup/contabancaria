package com.contabancaria.contabancaria.repository;

import com.contabancaria.contabancaria.model.ContaBancaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends CrudRepository<ContaBancaria,Long> {

}
