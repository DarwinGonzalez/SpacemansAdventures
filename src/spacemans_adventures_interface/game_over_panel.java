package spacemans_adventures_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class game_over_panel extends JPanel { // Clase para la implementación de un panel de GAME OVER.
	
	//-----> DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE.
	
		private Dimension dimension_backgroundpanel;
		private JButton button_back;

	//-----> DECLARACIÓN DE LOS MÉTODOS DE LA CLASE.
		
	public game_over_panel(Dimension size_backgroundpanel) { // Constructor.
		
		// Inicialización de los atributos de la clase.
		dimension_backgroundpanel = size_backgroundpanel;
		button_back = new JButton("VOLVER"); // Pasamos el String directamente al constructor.
		
		this.add_characteristics(); // Llamada al método add_characteristics() pasando las dimensiones del JFrame por parámetro.
		this.add_components(); // Llamada al método add_components().
		this.add_Layout(); // Llamada al método add_Layout().
	}

	public void add_characteristics() { // Método para añadir las características de nuestro panel.
		
		this.setLayout(null); // Eliminamos el gestor de Layout por defecto para establecer nuestra propia colocación.
		this.setSize(new Dimension(350,300)); // Establecemos las dimensiones de nuestro panel.
		this.setLocation(((int)(dimension_backgroundpanel.getWidth()/2)-(this.getWidth()/2)),((int)(dimension_backgroundpanel.getHeight()/2)-(this.getHeight()/2))); // Añadimos una localización a nuestro panel.
		this.setBorder(new LineBorder(new Color(208,168,10),3)); // Establecemos un borde para nuestro panel.
	
	}
	
	public void add_components() { // Método para añadir los elementos a nuestro panel.
		
		this.add(button_back); // Añadimos el botón de VOLVER.
	}
	
	public void add_Layout() { // Método para elegir la distribución y el tamaño de nuestros elementos.
		
		button_back.setBounds(200,200,100,40);
	}
	
	//-----> SOBRECARGA DEL MÉTODO PAINT.
	
	@Override
	public void paint(Graphics g) { // Sobrecargamos el método paint de nuestro panel para añadir una imagen de fondo al mismo.
		
		g.drawImage(new ImageIcon("images/backgrounds/background_game_over_panel.png").getImage(),0,0,this.getWidth(),this.getHeight(),null); 
		this.setOpaque(false); // Indicamos a nuestro panel que no muestre el fondo por defecto.
		super.paint(g); // Indicamos al panel que siga mostrando el resto de elementos por defecto.
	}

}
