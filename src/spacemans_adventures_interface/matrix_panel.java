package spacemans_adventures_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class matrix_panel extends JPanel { // Método para formar el panel que contendrá la matriz de nuestro programa.
	
//-----> DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE.
	
	private matrix game_board; // Declaramos una matriz que será nuestro tablero de juego.
	private int difficulty_game; // Declaramos una variable para almacenar la dificultad del juego.
	private int scale_game; // Declaramos una variable para almacenar la escala del juego.
	private int map_selected; // Variable para determinar cual es el mapa selecionado.
	
//-----> DECLARACIÓN DE LOS MÉTODOS DE LA CLASE.
	
	public matrix_panel(int mainpanel_size, int scale) { // Constructor.
		
		// Inicialización de los atributos de la clase.
		game_board = new matrix(scale,scale); // Establecemos una matriz cuadrada de la escala pasada por parámetro.
		difficulty_game = 0; // Inicializamos a 0 el valor de dificultad.
		scale_game = (int) mainpanel_size / scale; // Almacenamos en la variable de scale_game el tamaño de una celda de nuestro mapa.
		map_selected = 0; // Inicializamos a 0 la variable del mapa.
		
		add_characteristics(); // Llamada al método add_characteristics().
	}
	
	public void add_characteristics() { // Método para añador las características de nuestro panel.
		
		this.setSize(new Dimension(700,700)); // Añadimos las mismas dimensiones que al mainpanel (zona de juego).
	}

	public int select_difficulty(int difficulty) { // Método que transforma el valor de dificultad en un numero máximo de espacios.
		
		switch(difficulty) { // Switch para asignar el valor dependiendo del parámetro.
		case 0: // NIVEL FÁCIL.
			difficulty_game = 80;
		break;
		case 1: // NIVEL MEDIO.
			difficulty_game = 35;
		break;
		
		case 2: // NIVEL DÍFICIL
			difficulty_game = 15;
		break;
		case 3: // NIVEL EXTREMO.
			difficulty_game = 5;
		break;
		}
		
		return difficulty_game; // Retornamos el valor de dificultad para poder usarlo en otras clases.
	}
	
	public void selection_map(Graphics g) { // Método para selecionar el mapa que se mostrará.
		
		String name_map = ""; // Creamos una variable local para almacenar el distintivo de cada mapa.
		
		switch(map_selected) { // Sitch para seleccionar el mapa dependiendo de lo introducido por el usuario.
		case 0: // MAPA DEL ESPACIO ESTELAR.
			name_map = "space.gif"; // Asignamos una cadena a name_map.
		break;
		case 1: // MAPA DEL ESPACIO ESTELAR HD.
			name_map = "space.gif"; // Asignamos una cadena a name_map.
		break;
		case 2: // MAPA DE FONDO DE BIKINI.
			name_map = "fondodebikini.png"; // Asginamos una cadena a name_map.
		break;
		case 3: // MAPA DE POKEMON.
			name_map = "pokemon.png"; // Asignamos una cadena a name_map.
		break;
		case 4: // MAPA DE SPRINGFIELD.
			name_map = "springfield.png"; // Asignamos una cadena a name_map.
		break;
		case 5: // MAPA DE COMPUTER ENGINEERS.
			name_map = "computerengineers.png"; // Asignamos una cadena a name_map.
		break;
		}
		
		g.drawImage(new ImageIcon("images/backgrounds/background_" + name_map).getImage(),0,0,700,700,this);
	}
	
	public void draw_board(Graphics g) { // Método para asignar elementos gráficos a nuestra matriz.
		
		String name_elements = ""; // Creamos una variable local para almacenar el distintivo de los personajes.
		
		switch(map_selected) { // Sitch para seleccionar los personajes dependiendo de lo introducido por el usuario.
		case 0: // MAPA DEL ESPACIO ESTELAR.
			name_elements = "space"; // Asignamos una cadena a name_elements.
		break;
		case 1: // MAPA DEL ESPACIO ESTELAR HD.
			name_elements = "spaceHD"; // Asignamos una cadena a name_elements.
		break;
		case 2: // MAPA DE FONDO DE BIKINI.
			name_elements = "fondodebikini"; // Asignamos una cadena a name_elements.
		break;
		case 3: // MAPA DE POKEMON.
			name_elements = "pokemon"; // Asignamos una cadena a name_elements.
		break;
		case 4: // MAPA DE SPRINGFIELD.
			name_elements = "springfield"; // Asignamos una cadena a name_elements.
		break;
		case 5: // MAPA DE COMPUTER ENGINEERS.
			name_elements = "computerengineers"; // Asignamos una cadena a name_elements.
		break;
		}
		
		for(int i = 0; i < game_board.get_rows(); i++) {
			for(int j = 0; j < game_board.get_columns(); j++) {
				if(game_board.get_value(i,j) == 100) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de ironmonger.
						g.drawImage(new ImageIcon("images/elements/characters/ironmonger.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
				}
				if(game_board.get_value(i,j) == 101) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de ironmonger.
					g.drawImage(new ImageIcon("images/elements/explosion.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
				}
				if(game_board.get_value(i,j) == 102) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de ironmonger.
					g.drawImage(new ImageIcon("images/elements/camino.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
				}
				if(game_board.get_value(i,j) == 103) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de ironmonger.
					g.drawImage(new ImageIcon("images/elements/attack_distance.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
				}
				if((game_board.get_value(i,j) >= 80) && (game_board.get_value(i,j) < 100)) { // CONDICIÓN: Si los valores de la matriz están entre 80 y 99 (VALORES DE SPACEMAN Y IRONMONGER).
					if(game_board.get_value(i,j) == 80) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 81) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman vertical ascendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_vertical_asc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 82) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman vertical descendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_vertical_desc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 83) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman horizontal ascendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_horizontal_asc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 84) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman horizontal descendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_horizontal_desc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 85) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman diagonal derecho ascendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_diagder_asc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 86) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman diagonal izquierdo descendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_diagder_desc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 87) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman diagonal izquierdo ascendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_diagizq_asc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 88) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman diagonal izquierdo descendente.
						g.drawImage(new ImageIcon("images/elements/characters/movements/spaceman_diagizq_desc.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 89) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman diagonal izquierdo descendente.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 90) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman attack gif.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman_attack_right.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 91) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman attack png.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman_attack_right.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 92) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman attack gif.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman_attack_left.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 93) { // CONDICIÓN: Si el valor de la matriz coincide con un valor de spaceman attack png.
						g.drawImage(new ImageIcon("images/elements/characters/spaceman_attack_left.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
				}
				if((game_board.get_value(i,j) > 3) && (game_board.get_value(i,j) < difficulty_game)) { // CONDICIÓN: Si el elemento de la matriz es mayor que 3 (Todos serán espacios).
					g.drawImage(new ImageIcon("images/elements/espacio.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, null);
					// Método drawImage: Nos permite cargar una imagen haciendo uso del método getImage().
					// Debemos pasar por parámetros el fichero de imagen, coordenada x, coordenada y, alto de la imagen, ancho de la imagen, ImageObserver.
				}
				if(game_board.get_value(i,j) <= 3) { // CONDICIÓN: Si el elemento de la matriz es menor o igual que 3 (Todos serán obstaculos).
					if(game_board.get_value(i,j) == -1) { // CONDICIÓN: Si el valor es igual -1 (inicialización de la matriz).
						g.drawImage(new ImageIcon("images/elements/espacio.png").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, null);
					}
					if(game_board.get_value(i,j) == 0) { // CONDICIÓN: Si el valor es igual 0 (MARTE).
						g.drawImage(new ImageIcon("images/elements/obstacles/" + name_elements + "/obstaculo_0.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 1) { // CONDICIÓN: Si el valor es igual 1 (LUNA).
						g.drawImage(new ImageIcon("images/elements/obstacles/" + name_elements + "/obstaculo_1.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 2) { // CONDICIÓN: Si el valor es igual 2 (NAVE).
						g.drawImage(new ImageIcon("images/elements/obstacles/" + name_elements + "/obstaculo_2.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
					if(game_board.get_value(i,j) == 3) { // CONDICIÓN: Si el valor es igual 3 (OVNI).
						g.drawImage(new ImageIcon("images/elements/obstacles/" + name_elements + "/obstaculo_3.gif").getImage(), j*scale_game, i*scale_game, scale_game, scale_game, this);
					}
				}		
			}
		}
	}
	
	//-----> SOBRECARGA DEL MÉTODO PAINT.
	
	@Override // Indicamos al compilador que vamos a realizar una sobrecarga del método paint, para que compruebe si la sobrecarga es correcta.
	public void paint(Graphics g) { // Método para poder insertar elementos gráficos.
		super.paintComponent(g); // Uso obligatorio en la sobrecarga del paint().
		this.selection_map(g);
		this.draw_board(g); // Llamada al método draw_board().
	}

	public matrix getGame_board() { // Método para retornar el atributo game_board.
		return game_board;
	}

	public void setGame_board(matrix game_board) { // Método para establecer un atributo game_board.
		this.game_board = game_board;
	}

	public int getScale_game() {
		return scale_game;
	}

	public void setScale_game(int scale_game) {
		this.scale_game = scale_game;
	}

	public int getMap_selected() {
		return map_selected;
	}

	public void setMap_selected(int map_selected) {
		this.map_selected = map_selected;
	}
	
}
