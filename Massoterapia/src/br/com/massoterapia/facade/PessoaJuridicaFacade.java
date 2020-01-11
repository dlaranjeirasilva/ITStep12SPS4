package br.com.massoterapia.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.massoterapia.dao.JdbcDAOFactory;
import br.com.massoterapia.model.PessoaJuridica;

public class PessoaJuridicaFacade {
	
	public List<PessoaJuridica> listarPJs() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<PessoaJuridica> pjs = new ArrayList<PessoaJuridica>();
		
		String sql = "SELECT ID, CNPJ FROM T12SPS4.PESSOA_JURIDICA;";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			PessoaJuridica pj = new PessoaJuridica();
			pj.setId(rs.getLong("id"));
			pj.setCnpj(rs.getString("cnpj"));
			
			pjs.add(pj);
			
		}
		
		return pjs;
		
	}
	
	

}
