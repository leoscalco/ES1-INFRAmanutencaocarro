/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unioeste.manutencao.serv.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import unioeste.manutencao.bo.ordemServico.TipoServico;
import unioeste.manutencao.infra.configuracao.ConexaoMySQL;
import unioeste.manutencao.serv.ordemservico.DaoTipoServico;
import unioeste.manutencao.serv.veiculo.DaoVeiculo;

/**
 *
 * @author leoscalco
 */
public class UCServico {
    
    Connection conn;
    
     public Connection abrirConexao(){
        return ConexaoMySQL.getConexaoMySQL();
    }
    
    public void fecharConexao(){
        ConexaoMySQL.FecharConexao();
    }
    
    public void cadastrar(TipoServico tiposervico) throws SQLException, Exception{
        conn = abrirConexao();
        
        DaoTipoServico dao = new DaoTipoServico(conn);
        dao.save(tiposervico);
        
        fecharConexao();
    }

    public ArrayList<TipoServico> autoComplete(String query) throws SQLException, Exception {
        conn = abrirConexao();
        
        DaoTipoServico dao = new DaoTipoServico(conn);
        ArrayList<TipoServico> ret;
        ret = dao.servicosByNome(query);
        
        fecharConexao();
        
        return ret;
    }

}
