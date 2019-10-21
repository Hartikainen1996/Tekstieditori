import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tekstieditori extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnTiedosto;
	private JMenu mnMuokkaa;
	private JMenu mnTietoja;
	private JMenuItem mntmAvaa;
	private JMenuItem mntmTallenna;
	private JMenuItem mntmLopeta;
	private JMenuItem mntmSulje;
	private JMenuItem mntmEtsi;
	private JMenuItem mntmKorvaa;
	private JMenuItem mntmTietojaOhjelmasta;
	private JToolBar toolBar;
	private JButton button;
	private JButton button_1;
	private JButton btnKorvaa;
	private JEditorPane editorPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					tekstieditori frame = new tekstieditori();
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
	public tekstieditori() {
		setTitle("Tekstieditori");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		
		mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Avaus koodi
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(contentPane);
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");

				String rivi = "";
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				
				
				try {
				Scanner lukija = null;
				File tiedosto = new File(uusiTiedosto);
				lukija = new Scanner(tiedosto);
					}
				 catch (FileNotFoundException p) {
					System.out.println("Tiedostoa ei löydy..");
				}
				editorPane.setText(rivi);
			}
				
			}
		);
		mntmAvaa.setIcon(new ImageIcon(tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/newFolder.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);
		
		
		mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.setIcon(new ImageIcon(tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tallennusikkuna
				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(contentPane);
				
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				
				System.out.println("Kirjoitettava tiedosto: "+uusiTiedosto);
				
				
				//Tallennus koodi
				try {
				
				PrintWriter writer = new PrintWriter(uusiTiedosto);
				String sisalto = editorPane.getText();
				
				writer.println( sisalto );
				
				writer.flush();
				writer.close();
				
			} catch (Exception e1) {
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}
			}
		}
		);
		mnTiedosto.add(mntmTallenna);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.setIcon(new ImageIcon(tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmLopeta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		mnTiedosto.add(mntmLopeta);
		
		mntmSulje = new JMenuItem("Sulje");
		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
			}
		});
		mnTiedosto.add(mntmSulje);
		
		mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);
		
		mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String haettava = JOptionPane.showInputDialog(contentPane, "Anna haettava sana. ");
				// Etsi toiminto
				
				String sisalto = editorPane.getText();
				sisalto = sisalto.toLowerCase();
				
			
				int indeksi = sisalto.indexOf(haettava);
				System.out.println("Indeksi: "+indeksi);
				
				editorPane.setSelectionColor(Color.CYAN);
				
				editorPane.setSelectionStart(indeksi);
				editorPane.setSelectionEnd( indeksi + haettava.length() );
			}
		}
				);
		mnMuokkaa.add(mntmEtsi);
		
		mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String korvattava = JOptionPane.showInputDialog(contentPane, "Mikä sana korvataan? ");
				String korvaus = JOptionPane.showInputDialog(contentPane, "Millä sanalla korvataan? ");
				String sisalto = editorPane.getText();
				String replaceString = sisalto.replaceAll(korvattava, korvaus);
				editorPane.setText(replaceString);
				
			}
			});
		
		mnMuokkaa.add(mntmKorvaa);
		
		mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);
		
		mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(contentPane, "Eemil Hartikainen \n eemilhartikainen.fi", "Tekijän tiedot", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(contentPane);
				valintaikkuna.setApproveButtonText("Avaa tiedosto");
				valintaikkuna.setDialogTitle("Tiedoston valinta");

				String rivi = "";
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				
				
				try {
				Scanner lukija = null;
				File tiedosto = new File(uusiTiedosto);
				lukija = new Scanner(tiedosto);
					}
				 catch (FileNotFoundException p) {
					System.out.println("Tiedostoa ei löydy..");
				}
				editorPane.setText(rivi);
			}
			}
		);
		button.setIcon(new ImageIcon(tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(button);
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(contentPane);
				
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				
				System.out.println("Kirjoitettava tiedosto: "+uusiTiedosto);
				
				
			
				try {
				
				PrintWriter writer = new PrintWriter(uusiTiedosto);
				String sisalto = editorPane.getText();
				
				writer.println( sisalto );
				
				writer.flush();
				writer.close();
				
			} catch (Exception e1) {
				System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
				e1.printStackTrace();
			}
			}
		});
		button_1.setIcon(new ImageIcon(tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(button_1);
		
		btnKorvaa = new JButton("");
		btnKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String korvattava = JOptionPane.showInputDialog(contentPane, "Mikä sana korvataan? ");
				String korvaus = JOptionPane.showInputDialog(contentPane, "Millä sanalla korvataan? ");
				String sisalto = editorPane.getText();
				String replaceString = sisalto.replaceAll(korvattava, korvaus);
				editorPane.setText(replaceString);
			}
		});
		btnKorvaa.setIcon(new ImageIcon(tekstieditori.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut-Black.png")));
		toolBar.add(btnKorvaa);
		
		editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}
}
