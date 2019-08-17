package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Agendamento;
import br.com.consultemed.models.Medico;
import br.com.consultemed.models.Paciente;
import br.com.consultemed.services.AgendamentoService;
import br.com.consultemed.services.MedicoService;
import br.com.consultemed.services.PacienteService;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class AgendamentoController {
	
	@Getter
	@Setter
	private List<Agendamento> agendamentos;

	@Inject
	@Getter
	@Setter
	private Agendamento agendamento;
	
	@Getter
	@Setter
	private Agendamento agendamentoEditar;
	
	@Inject
	private AgendamentoService service;
	
	@Getter
	@Setter
	private Medico medico;
	
	@Inject
	private MedicoService medicoService;
	
	@Getter
	@Setter
	private List<Medico> medicos;
	
	@Getter
	@Setter
	private Paciente paciente;
	
	@Inject
	private PacienteService pacienteService;
	
	@Getter
	@Setter
	private List<Paciente> pacientes;
	
	
	public String editar() {
		this.agendamento = this.agendamentoEditar;
		return "/pages/agendamentos/addAgendamento.xhtml";
	}
	
	public String excluir() throws Exception {
		this.agendamento = this.agendamentoEditar;
		this.service.deletarFuncionario(this.agendamento.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/agendamentos/agendamentosDia.xhtml?faces-redirect=true";
	}
	
	public String novoAgendamento() {
		this.agendamento = new Agendamento();
		return "/pages/agendamentos/addAgendamentos.xhtml?faces-redirect=true";
	}
	
	public String addAgendamento() {
		this.service.salvarAgendamento(this.agendamento);
		return "/pages/agendamentos/agendamentosDia.xhtml?faces-redirect=true";
	}
	
	public List<Agendamento> listaAgendamentos(){
		this.agendamentos = this.service.listaAgendamento();
		return agendamentos;
	}
	
	public void carregarMedicos(){
		this.medicos = this.medicoService.listaMedico();
	}
	public void carregarPacientes() {
		this.pacientes = this.pacienteService.listaPaciente();
	}

}
