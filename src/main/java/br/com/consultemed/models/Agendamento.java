package br.com.consultemed.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({ @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a")})
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_AGENDAMENTO")
public class Agendamento {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Getter
	@Setter
	@JoinColumn(name = "ID_MEDICO")
	@ManyToOne
	private Medico medico;
	
	@Getter
	@Setter
	@JoinColumn(name = "ID_PACIENTE")
	@ManyToOne
	private Paciente paciente;
	
	@Getter
	@Setter
	@Column(name = "DH_AGENDADA")
	private Date dataAgendada;
	
	
	

}
