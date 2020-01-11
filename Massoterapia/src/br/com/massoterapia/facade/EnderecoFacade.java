package br.com.massoterapia.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.massoterapia.dao.JdbcDAOFactory;
import br.com.massoterapia.model.Endereco;
//import br.com.massoterapia.model.Pessoa;

public class EnderecoFacade {
	
	public List<Endereco> listarTodosEnderecos() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		String sql = "SELECT ID, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, CIDADE, UF, CEP, ID_PESSOA, TIPO_ENDERECO FROM T12SPS4.ENDERECO";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
//			Pessoa pessoa = new Pessoa();
			Endereco endereco = new Endereco();
			endereco.setId(rs.getLong("id"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setComplemento(rs.getString("complemento"));
			endereco.setNumero(rs.getString("numero"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setUf(rs.getString("uf"));
			endereco.setCep(rs.getString("cep"));
//			endereco.setPessoa(rs.getLong("idPessoa"));
			endereco.setTipoEndereco(rs.getString("tipoEndereco"));
			
			enderecos.add(endereco);
			
		}
		
		return enderecos;
		
	}

}
