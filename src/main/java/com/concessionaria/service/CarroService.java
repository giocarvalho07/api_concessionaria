package com.concessionaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.concessionaria.model.Carro;
import com.concessionaria.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepository;


	public Carro cadastrarCarro(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public void deletarCarro(Carro carro) {
		carroRepository.delete(carro);
	}
	
	public List<Carro> listarCarro(){
		return carroRepository.findAll();
	}
	
	public Carro idCarro(Long id) {
		return carroRepository.findById(id).get();
	}

}
