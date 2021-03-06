package spacemans_adventures_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class start_panel extends JPanel { // Clase para implementar un panel central que nos saldrá al inicio o cuando el usuario pulse pause.
	
//-----> DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE.
	
	private Dimension dimension_backgroundpanel;
	private JButton button_start;
	private JLabel difficulty_label;
	private String[] levels = {"NIVEL 1 - Fácil", "NIVEL 2 - Normal", "NIVEL 3 - Difícil", "NIVEL 4 - Extremo"};
	private JComboBox<String> difficulty_box;
	private JLabel size_matrix_label;
	private String[] sizes = {"10 X 10", "20 X 20", "30 X 30", "40 X 40", "50 X 50", "60 X 60", "70 X 70", "80 X 80", "90 X 90", "100 X 100"};
	private JComboBox<String> size_matrix_box;
	private JLabel map_label;
	private String[] maps = {"Espacio Estelar", "Espacio Estelar HD", "Fondo de Bikini", "Pokemon", "Springfield", "Computer Engineers"};
	private JComboBox<String> map_box; 
	private JButton button_exit;
	
//-----> DECLARACIÓN DE LOS MÉTODOS DE LA CLASE.
	
	public start_panel(Dimension size_backgroundpanel) { // Constructor.
		
		// Inicialización de los atributos de la clase.
		dimension_backgroundpanel = size_backgroundpanel;
		button_start = new JButton("JUGAR"); // Pasamos el String directamente al constructor.
		difficulty_label = new JLabel("DIFICULTAD");
		difficulty_box = new JComboBox<String>(levels);
		size_matrix_label = new JLabel("TAMAÑO");
		size_matrix_box = new JComboBox<String>(sizes);
		map_label = new JLabel("MAPA DE JUEGO");
		map_box = new JComboBox<String>(maps);
		button_exit = new JButton("SALIR");
		
		this.add_characteristics(); // Llamada al método add_characteristics() pasando las dimensiones del JFrame por parámetro.
		this.add_components(); // Llamada al método add_components().
		this.edit_font(); // Llamada al método edit_font().
		this.add_Layout(); // Llamada al método add_Layout().
		this.setVisible(true); // Hacemos visible nuestro startpanel.		
	}
	
	public void add_characteristics() { // Método para añadir las características de nuestro panel.
		
		this.setLayout(null); // Eliminamos el gestor de Layout por defecto para establecer nuestra propia colocación.
		this.setSize(new Dimension(350,530)); // Establecemos las dimensiones de nuestro panel.
		this.setLocation(((int)(dimension_backgroundpanel.getWidth()/2)-(this.getWidth()/2)),((int)(dimension_backgroundpanel.getHeight()/2)-(this.getHeight()/2))); // Añadimos una localizacióna nuestro initialpanel.
		this.setBorder(new LineBorder(new Color(208,168,10),3)); // Establecemos un borde para nuestro panel.
	}
	
	public void add_components() { // Método para añadir los elementos a nuestro panel.
		
		this.add(button_start); // Añadimos el botón de START.
		this.add(difficulty_label); // Añadimos una etiqueta informativa al desplegable de dificultades.
		this.add(difficulty_box); // Añadimos el desplegable con los niveles de dificultad.
		this.add(size_matrix_label); // Añadimos una etiqueta informativa al desplegable de tamaños.
		this.add(size_matrix_box); // Añadimos el desplegable con los tamaños de tablero.
		this.add(map_label); // Añadimos una etiqueta informativa al desplegable de mapas.
		this.add(map_box); // Añadimos el desplegable con los mapas disponibles.
		this.add(button_exit); // Añadimos el botón de EXIT.
	}
	
	public void edit_font() { // Método que edita las fuentes de los elementos del panel.
		
		button_start.setFont(new Font("Tahoma",Font.BOLD,16)); // Editamos el tipo de fuente, el estilo y el tamaño.
		button_start.setForeground(Color.black); // Editamos el color de la fuente.
		difficulty_label.setFont(new Font("Tahoma",Font.BOLD,16));
		difficulty_label.setForeground(Color.white);
		difficulty_box.setFont(new Font("Tahoma",Font.PLAIN,13));
		difficulty_box.setForeground(Color.black);
		size_matrix_label.setFont(new Font("Tahoma",Font.BOLD,16));
		size_matrix_label.setForeground(Color.white);
		size_matrix_box.setFont(new Font("Tahoma",Font.PLAIN,14));
		size_matrix_box.setForeground(Color.black);
		map_label.setFont(new Font("Tahoma",Font.BOLD,16));
		map_label.setForeground(Color.white);
		map_box.setFont(new Font("Tahoma",Font.PLAIN,14));
		map_box.setForeground(Color.black);
		button_exit.setFont(new Font("Tahoma",Font.BOLD,16));
		button_exit.setForeground(new Color(185,4,4));
	}
	
	public void add_Layout() { // Método para elegir la distribución y el tamaño de nuestros elementos.
		
		button_start.setBounds(30,25,290,45); // Elegimos una posición y un tamaño para nuestro botón de START.
		difficulty_label.setBounds(65,72,150,20); // Elegimos una posición y un tamaño para nuestra etiqueta de DIFFICULTY.
		difficulty_box.setBounds(30,92,165,20); // Elegimos una posición y un tamaño para nuestro combobox de DIFFICULTY.
		size_matrix_label.setBounds(222,72,150,20); // Elegimos una posición y un tamaño para nuestra etiqueta de SIZE.
		size_matrix_box.setBounds(195,92,125,20); // Elegimos una posición y un tamaño para nuestro combobox de SIZE.
		map_label.setBounds(110,115,300,20); // Elegimos una posición y un tamaño para nuestra etiqueta de MAPS.
		map_box.setBounds(30,135,290,20); // Elegimos una posición y un tamaño para nuestro combobox de MAPS.
		button_exit.setBounds(30,160,290,45); // Elegimos una posición y un tamaño para nuestro botón de EXIT.
	}
	
	//-----> SOBRECARGA DEL MÉTODO PAINT.
	
	@Override
	public void paint(Graphics g) { // Sobrecargamos el método paint de nuestro panel para añadir una imagen de fondo al mismo.
		
		g.drawImage(new ImageIcon("images/backgrounds/background_start_panel.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); // Indicamos a nuestro panel que no muestre el fondo por defecto.
		super.paint(g); // Indicamos al panel que siga mostrando el resto de elementos por defecto.
	}
	
	//-----> MÉTODO SETTERS AND GETTERS.

	public JButton getButton_start() {
		return button_start;
	}

	public void setButton_start(JButton button_start) {
		this.button_start = button_start;
	}

	public JButton getButton_exit() {
		return button_exit;
	}

	public void setButton_exit(JButton button_exit) {
		this.button_exit = button_exit;
	}

	public JComboBox<String> getDifficulty_box() {
		return difficulty_box;
	}

	public void setDifficulty_box(JComboBox<String> difficulty_box) {
		this.difficulty_box = difficulty_box;
	}

	public JComboBox<String> getSize_matrix_box() {
		return size_matrix_box;
	}

	public void setSize_matrix_box(JComboBox<String> size_matrix_box) {
		this.size_matrix_box = size_matrix_box;
	}

	public JComboBox<String> getMap_box() {
		return map_box;
	}

	public void setMap_box(JComboBox<String> map_box) {
		this.map_box = map_box;
	}	
}
