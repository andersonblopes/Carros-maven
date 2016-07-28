package br.com.livro.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CarroService {

	@Autowired
	private CarroDAO dao;

	public List<Carro> getCarros() {
		List<Carro> carros = dao.getCarros();
		return carros;
	}

	public Carro getCarro(Long id) {
		return dao.getCarroById(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Long id) {
		return dao.delete(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean save(Carro c) {
		dao.saveOrUpdate(c);
		return true;
	}

	public List<Carro> findByName(String nome) {
		return dao.findByName(nome);
	}

	public List<Carro> findByTipo(String tipo) {
		return dao.findByTipo(tipo);
	}

}
