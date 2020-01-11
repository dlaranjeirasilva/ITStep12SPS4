package br.com.massoterapia.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import br.com.massoterapia.facade.PessoaFisicaFacade;
import br.com.massoterapia.model.PessoaFisica;

@Path("/pessoa")
public class PessoaFisicaController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarTodasPFs")
	public List<PessoaFisica> listarPessoasFisicas(@Context HttpHeaders httpHeaders) {
		List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
		PessoaFisicaFacade pessoaFisicaFacade = new PessoaFisicaFacade();
		
		try {
			pessoasFisicas = pessoaFisicaFacade.listarPessoasFisicas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return pessoasFisicas;
		
	}

}
