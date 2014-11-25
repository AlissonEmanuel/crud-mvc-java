package delegacia.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import delegacia.auxiliar.Auxiliar;
import delegacia.model.Cadastro;
import delegacia.util.CadastroTableModel;

public class TelaListar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private Auxiliar auxiliar;
	private CadastroTableModel cadastroTableModel;
	private List<Cadastro> cadastros = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListar frame = new TelaListar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(22, 31, 595, 367);
		contentPane.add(table);
		
		auxiliar = new Auxiliar();
		cadastros = auxiliar.listar();
		
		cadastroTableModel = new CadastroTableModel(cadastros);
		table.setModel(cadastroTableModel);
	}

}
