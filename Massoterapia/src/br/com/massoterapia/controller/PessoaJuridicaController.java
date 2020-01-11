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

import br.com.massoterapia.facade.PessoaJuridicaFacade;
import br.com.massoterapia.model.PessoaJuridica;

@Path("/pessoa")
public class PessoaJuridicaController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarTodasPJs")
	public List<PessoaJuridica> listarPJs(@Context HttpHeaders httpHeaders) {
		List<PessoaJuridica> pjs = new ArrayList<PessoaJuridica>();
		PessoaJuridicaFacade pjFacade = new PessoaJuridicaFacade();
		
		try {
			pjs = pjFacade.listarPJs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return pjs;
		
	}

}
