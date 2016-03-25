package br.com.socialbooksapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.socialbooksapi.domain.Livro;
import br.com.socialbooksapi.repository.LivrosRepository;
import br.com.socialbooksapi.service.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro>listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id){
		Livro livro = livrosRepository.findOne(id);
		
		if(livro == null){
			throw new LivroNaoEncontradoException("O livro nao foi encontrado");
		}
		
		return null;
	}
	
	public Livro salvar(Livro livro){
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id){
		try {
			
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro nao pôde ser encontrado");
		}
	}
	
	public void atualizar(Livro livro){
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro){
		this.buscar(livro.getId());
	}
}
