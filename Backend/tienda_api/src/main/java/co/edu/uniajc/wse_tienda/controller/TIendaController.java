package co.edu.uniajc.wse_tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.wse_tienda.model.Tienda;
import co.edu.uniajc.wse_tienda.service.TiendaService;


@RestController
@RequestMapping("/tienda")
@CrossOrigin
public class TIendaController {

	@Autowired
	private TiendaService fabricaService;
	
	@PostMapping(path="/insert")
	public Tienda insertEstado(@RequestBody Tienda tienda) {
		return fabricaService.saveEstado(tienda);
	}
	
	@PutMapping(path="/update")
	public Tienda updateEstado(@RequestBody Tienda tienda) {
		return fabricaService.updateEstado(tienda);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteEstado(@PathVariable int id) {
		fabricaService.deleteEstado(id);
	}
	
	@GetMapping(path="/all")
	public List<Tienda> listar(){
		return fabricaService.listar();
	}
	/*
	@GetMapping(path="/find/{codigo}")
	public Estados getFindByIdEstado(@PathVariable("codigo") int id) {
		return estadosService.getByIdEstado(id);
	}*/
}
