package co.edu.uniajc.wse_fabrica.controller;

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

import co.edu.uniajc.wse_fabrica.model.Fabrica;
import co.edu.uniajc.wse_fabrica.service.FabricaService;


@RestController
@RequestMapping("/fabrica")
@CrossOrigin
public class FabricaController {

	@Autowired
	private FabricaService fabricaService;
	
	@PostMapping(path="/insert")
	public Fabrica insertEstado(@RequestBody Fabrica fabrica) {
		return fabricaService.saveEstado(fabrica);
	}
	
	@PutMapping(path="/update")
	public Fabrica updateEstado(@RequestBody Fabrica fabrica) {
		return fabricaService.updateEstado(fabrica);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void deleteEstado(@PathVariable int id) {
		fabricaService.deleteEstado(id);
	}
	
	@GetMapping(path="/all")
	public List<Fabrica> listar(){
		return fabricaService.listar();
	}
	/*
	@GetMapping(path="/find/{codigo}")
	public Estados getFindByIdEstado(@PathVariable("codigo") int id) {
		return estadosService.getByIdEstado(id);
	}*/
}
