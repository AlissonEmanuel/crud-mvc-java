package delegacia.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import delegacia.model.Cadastro;

public class CadastroTableModel extends AbstractTableModel{

	private List<Cadastro> cadastros;
	
	public CadastroTableModel(List<Cadastro> cadastros){
		this.cadastros = cadastros;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.cadastros.size();
	}

	public String getColumnName(final int column){
		switch(column){
		case 0:
			return "id";
		case 1:
			return "nome";
		case 2:
			return "cargo";
			default: return "?";
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cadastro cadastro = cadastros.get(rowIndex);
		
		switch(columnIndex){
		case 0:
			return cadastro.getId();
		case 1:
			return cadastro.getNome();
		case 2:
			return cadastro.getCargo();
			default: return null;
		}
		
	}
	
	public Cadastro getCadastro(int rowIndex){
		Cadastro cadastro = cadastros.get(rowIndex);
		return cadastro;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}
	

}
