package br.com.massoterapia.model;

import java.util.Date;

public class PessoaFisica extends Pessoa {
	
	private Date datNascimento;

	
	public Date getDatNascimento() {
		return datNascimento;
	}

	public void setDatNascimento(Date datNascimento) {
		this.datNascimento = datNascimento;
	}
	
	

}
