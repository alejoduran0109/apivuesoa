package co.edu.uniajc.wse_bodega.controller;

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

import co.edu.uniajc.wse_bodega.model.Bodega;
import co.edu.uniajc.wse_bodega.service.BodegaService;


@RestController
@RequestMapping("/bodega")
@CrossOrigin
public class BodegaController {

	@Autowired
	private BodegaService bodegaService;
	
	@PostMapping(path="/insert")
	public Bodega insertEstado(@RequestBody Bodega bodega) {
		return bodegaService.saveEstado(bodega);
	}
	
	@PutMapping(path="/update")
	public Bodega updateEstado(@RequestBody Bodega bodega) {
		return bodegaService.updateEstado(bodega);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteEstado(@PathVariable int id) {
		bodegaService.deleteEstado(id);
	}
	
	@GetMapping(path="/all")
	public List<Bodega> listar(){
		return bodegaService.listar();
	}
	/*
	@GetMapping(path="/find/{codigo}")
	public Estados getFindByIdEstado(@PathVariable("codigo") int id) {
		return estadosService.getByIdEstado(id);
	}*/
}
