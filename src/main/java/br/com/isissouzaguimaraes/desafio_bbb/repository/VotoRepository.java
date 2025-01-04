package br.com.isissouzaguimaraes.desafio_bbb.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.isissouzaguimaraes.desafio_bbb.entity.Voto;

public interface VotoRepository extends CrudRepository<Voto, Long> {
}