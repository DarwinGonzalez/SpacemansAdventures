package spacemans_adventures_interface;

import java.util.Random;

public class matrix {
	
//-----> DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE.
	
	private int[][] board; // Declaramos una matriz que utilizaremos como tablero de nuestro programa.
	private int rows; // Variable para almacenar el número de filas.
	private int columns; // Variable para almacenar el número de columnas.
		
//-----> DECLARACIÓN DE LOS MÉTODOS DE LA CLASE.
		
	public matrix(int rows, int columns) { // Constructor.
			
		// Inicialización de los atributos de la clase.
		this.rows = rows; // Establecemos el número de filas. 
		this.columns = columns; // Establecemos el número de columnas.
		board = new int[rows][columns]; // Establecemos las dimensiones de nuestra matriz.
		
		this.initialize_matrix(); // Llamada al método initialize_matrix().
	}
	
	public void initialize_matrix() { // Método para inicializar la matriz con un valor correspondiente a espacio negro.
		
		for(int i = 0; i < this.get_rows(); i++) {
			for(int j = 0; j < this.get_columns(); j++) {
				board[i][j] = -1; // Rellenamos nuestra matriz con -1.
			}
		}
	}
	
	public void insert_obstacles(int difficulty) { // Método para insertar los valores de nuestra matriz dependiendo de la dificultad.
		
		Random aleatory_values = new Random(); // Declaramos un objeto de la clase Ramdom.
		
		for(int i = 0; i < this.get_rows(); i++) {
			for(int j = 0; j < this.get_columns(); j++) {
				board[i][j] = aleatory_values.nextInt(difficulty); // Rellenamos nuestra matriz con enteros aleatorios en el rango 0-DIFICULTAD.
			}
		}
	}
	
	public void reset_characters() { // Método para eliminar al spaceman y al objetivo de la matriz.
		
		Random aleatory_values = new Random(); // Declaramos un objeto de la clase Ramdom.
		
		for(int i = 0; i < this.get_rows(); i++) {
			for(int j = 0; j < this.get_columns(); j++) {
				if((board[i][j] == 80) || (board[i][j] == 100)) {
					board[i][j] = (aleatory_values.nextInt(16) + 4);
				}
			}
		}
		
	}
	
	public void reset_path() { // Método para eliminar los elementos usados en el camino.
		
		Random aleatory_values = new Random(); // Declaramos un objeto de la clase Ramdom.
		
		for(int i = 0; i < this.get_rows(); i++) {
			for(int j = 0; j < this.get_columns(); j++) {
				if((board[i][j] == -1) || (board[i][j] >= 100) && (board[i][j] <= 103)) {
					board[i][j] = (aleatory_values.nextInt(16) + 4);				
				}
			}
		}
		
	}
		
	public int get_value(int row, int column) { // Método que devuelve un elemento de la matriz.
		return board[row][column];
	}
		
	public void set_value(int row, int column, int element) { // Método que sustituye un valor de la matriz por otro pasado por parámetro.
		board[row][column] = element;
	}
		
	public int get_rows() { // Método que nos devuelve el número de filas.
		return rows;
	}

	public void set_rows(int rows) { // Método que establece el número de filas pasado por parametro.
		this.rows = rows;
	}

	public int get_columns() { // Método que nos devuelve el número de columnas.
		return columns;
	}

	public void set_columns(int columns) { // Método que establece el número de columnas pasado por parámetro.
		this.columns = columns;
	}

}
