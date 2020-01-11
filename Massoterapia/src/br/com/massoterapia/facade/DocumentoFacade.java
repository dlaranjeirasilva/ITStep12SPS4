package br.com.massoterapia.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.massoterapia.dao.JdbcDAOFactory;
import br.com.massoterapia.model.Documento;

public class DocumentoFacade {
	
	public List<Documento> listarTodosDocumentos() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<Documento> documentos = new ArrayList<Documento>();
		
		String sql = "SELECT ID, ID_PESSOA, DESCRICAO, CONTEUDO FROM T12SPS4.DOCUMENTO";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Documento documento = new Documento();
			documento.setId(rs.getLong("id"));
//			documento.setPessoa(pessoa);
			documento.setDescricao(rs.getString("descricao"));
			documento.setConteudo(rs.getString("conteudo"));
			
			documentos.add(documento);
			
		}
		
		return documentos;
		
	}

}
