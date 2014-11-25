package delegacia.auxiliar;

import java.util.List;

import delegacia.controller.CadastroController;
import delegacia.model.Cadastro;

public class Auxiliar {

	private CadastroController cadastroController;
	
	public Auxiliar(){
		this.cadastroController = new CadastroController();
	}
	
	public void inserir(Cadastro cadastro){
		this.cadastroController.inserir(cadastro);
	}
	
	public void excluir(Cadastro cadastro){
		this.cadastroController.excluir(cadastro);
	}
	
	public void alterar(Cadastro cadastro){
		this.cadastroController.alterar(cadastro);
	}
	
	public List<Cadastro> listar(){
		return this.cadastroController.listar();
	}
}
