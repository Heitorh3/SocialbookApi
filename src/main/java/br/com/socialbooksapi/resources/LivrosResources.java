package br.com.socialbooksapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.socialbooksapi.domain.Livro;
import br.com.socialbooksapi.service.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	private LivrosService livrosService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Livro livro){
		livrosService.salvar(livro);
	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		Livro livro = livrosService.buscar(id);
	    return ResponseEntity.status(HttpStatus.OK).body(livro);
	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		livrosService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
		
		livro.setId(id);
		livrosService.atualizar(livro);
		
		return ResponseEntity.noContent().build();
	}
}