/**
 * 
 */
package app;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Código copiado e adaptado de https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SimpleTableDemoProject/src/components/SimpleTableDemo.java
 * 
 */
@SuppressWarnings("serial")
public class SimpleTableDemo extends JPanel {
	private boolean DEBUG = false;
	private JTable table;
	private JScrollPane scrollPane;
	
	public SimpleTableDemo() {
		super(new GridLayout(1,0));
		
		String[] columnNames = {
								"First Name",
								"Last Name",
								"Sport",
								"# of Years",
								"Vegetarian"};
		
		Object[][] data = {
				{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
				{"John", "Doe",
					"Rowing", new Integer(3), new Boolean(true)},
				{"Sue", "Black",
						"Knitting", new Integer(2), new Boolean(false)},
				{"Jane", "White",
							"Speed reading", new Integer(20), new Boolean(true)},
				{"Joe", "Brown",
								"Pool", new Integer(10), new Boolean(false)}
				};
		
		this.table = new JTable(data, columnNames); // preenche a tabela com os dados e configura as colunas.
		this.table.setPreferredScrollableViewportSize(new Dimension(500,70)); // Estabelece o tamanho da tabela
		this.table.setFillsViewportHeight(true); // Se a janela for redimensionada a tabela acompanha a janela de visualização, em termos de altura.
		
		if (DEBUG) {
			table.addMouseListener( new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}
		
		// leia o javadoc de ScrollPane para observar o papel dele aqui.
		this.scrollPane = new JScrollPane(table); 
		
		add(scrollPane);
	}
	
	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		TableModel model = table.getModel();
		
		System.out.println("Value of data: ");
		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Simple table model");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SimpleTableDemo std = new SimpleTableDemo();
		std.setOpaque(true);
		frame.setContentPane(std);
		
		// Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
		frame.pack();
		frame.setVisible(true);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
