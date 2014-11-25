package delegacia.controller;

import java.util.List;

import javax.swing.JOptionPane;

import delegacia.model.Cadastro;
import delegacia.model.CadastroDAO;

public class CadastroController {

	private CadastroDAO dao;
	
	public CadastroController(){
		this.dao=new CadastroDAO();
	}
	
	public void inserir(Cadastro cadastro){
		if(cadastro !=null && !cadastro.getNome().equals("") && !cadastro.getCargo().equals("")){
			dao.inserir(cadastro);
			JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!");
		}else{
			JOptionPane.showMessageDialog(null, "Todos os campos são necessários!");
		}
	}
	
	public void excluir(Cadastro cadastro){
		if(cadastro != null && cadastro.getId()>0){
			dao.excluir(cadastro);
			JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
		}else{
			JOptionPane.showMessageDialog(null, "Informe um cadastro a ser excluído!");
		}
	}
	
	public void alterar(Cadastro cadastro){
		if(cadastro !=null && !cadastro.getNome().equals("") && !cadastro.getCargo().equals("") && cadastro.getId()>0){
			dao.alterar(cadastro);
			JOptionPane.showMessageDialog(null, "Alteração concluida com sucesso!");
			
		}else{
			JOptionPane.showMessageDialog(null, "Todos os campos são necessários!");
		}
	}
	
	public List<Cadastro> listar(){
		return dao.listar();
	}
}
