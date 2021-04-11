package com.concessionaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.concessionaria.model.Carro;
import com.concessionaria.model.StatusCarro;
import com.concessionaria.service.CarroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Concessionaria de carros - API REST")
@RestController
@RequestMapping("/api/v1")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@GetMapping(value = {"/", "home"})
	@ApiOperation(value = "Rota home ")
	public @ResponseBody String home() {
		return "Bem vindo a concessionária e-Car";
	}
	
	@ApiOperation(value = "Rota cadastrar de carros")
	@PostMapping("/carro")
	public @ResponseBody Carro postCarro(@RequestBody Carro carro) {
		return carroService.cadastrarCarro(carro);
	}
	
	@ApiOperation(value = "Rota listar carros")
	@GetMapping("/carro")
	public @ResponseBody List<Carro> getCarro(){
		return carroService.listarCarro();
	}
	
	@ApiOperation(value = "Rota listar por id carros")
	@GetMapping("carro/{id}")
	public @ResponseBody Carro getIdCarro(@PathVariable Long id) {
		return carroService.idCarro(id);
	}
	
	@ApiOperation(value = "Rota editar carros")
	@PutMapping("/carro")
	public @ResponseBody Carro updateCarro(@RequestBody Carro carro) {
		return carroService.cadastrarCarro(carro);
	}
	
	@ApiOperation(value = "Rota deletar carros ")
	@DeleteMapping("/carro/{id}")
	public @ResponseBody StatusCarro deleteCarro(@PathVariable Long id) {
		StatusCarro statusCarro = new StatusCarro();
		
		try {
			Carro carro = getIdCarro(id);
			this.carroService.deletarCarro(carro);
			statusCarro.setStatus("Carro removido com sucesso");
		} catch (Exception erro) {
			statusCarro.setStatus("Falha ao remover o carro {" + erro.getMessage() + "}" );
		}
		
		return statusCarro;
	}
	
}
