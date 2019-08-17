package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Agendamento;
import br.com.consultemed.repository.repositories.AgendamentoRepository;

public class AgendamentoService {
	
	@Inject
	private AgendamentoRepository dao;
	
	public List<Agendamento> listaAgendamento(){
		return this.dao.listaAgendamentos();
	}
	
	public void salvarAgendamento(Agendamento agendamento) {
		this.dao.salvarAgendamento(agendamento);
	}
	
	public void deletarFuncionario(Long id) throws Exception {
		this.dao.deleteById(id);
	}

}
