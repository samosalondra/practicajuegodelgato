package practica;

import java.util.Scanner;

public class juegodelgato {

	static char[][] tablero = new char[3][3];
	static int jugadorTurno =1;
	static char[]simbolos =new char[3];
	public static void main(String[] args) {
		simbolos[0]= ' ';
		simbolos [1]= 'x';
		simbolos [2]= 'O';
		inicializarTablero();
		mostrarpantalla();
		jugar();
	}
	public static void inicializarTablero() {
		int pos = '1';
		for(int x=0; x<3; x++) {
			for (int y = 0; y < 3; y++) {
				tablero [x][y] =(char) pos;
				pos++;
			}
		}
	}

	public static void mostrarpantalla() {
		System.out.println(tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2]);
		System.out.println("---------");
		System.out.println(tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2]);
		System.out.println("---------");
		System.out.println(tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2]);
	}
	public static void jugar() {
		Scanner t = new Scanner(System.in) ;
		System.out.println("jugador "+jugadorTurno+ " juega con "+ simbolos[jugadorTurno]+". indique posicion del juego: ");
		int pos= t.nextInt();
		int x, y; 
		switch(pos) {
		case 1:
			x=0;
			y=0;
			break;
		case 2:
			x=0;
			y=1;
			break;
		case 3:
			x=0;
			y=2;
			break;
		case 4:
			x=1;
			y=0;
			break;
		case 5:
			x=1;
			y=1;
			break;
		case 6:
			x=1;
			y=2;
			break;
		case 7:
			x=2;
			y=0;
			break;
		case 8:
			x=2;
			y=1;
			break;
		case 9:
			x=2;
			y=2;
			break;
		default:
			System.out.println("posicion incorrecta, intente nuevamente....");
			jugar();
			t.close();
			return;
		}
		if (tablero[x][y] == 'x' || tablero [x][y]=='0') {
			System.out.println("la posicion ya esta siendo ocupada favor de intentarlo de nuevo");
			jugar();
			t.close();
			return;
		}
		tablero[x][y] = simbolos [jugadorTurno];
		if(!hayganador()) {
			if(jugadorTurno==1) {
				jugadorTurno++;
			}else {
				jugadorTurno--;
			}
			mostrarpantalla();
			jugar();
		} else {
			System.out.println("tenemos un ganador, desea volver a participar en este maginifico juego? (s:1 / n:0)");
			int continuar = t.nextInt();
			if(continuar== 1);
			inicializarTablero();
			mostrarpantalla();
			jugar();
			t.close();
			return;
		}

		t.close();
	}

	public static boolean hayganador() {
		if (tablero[0][0]== tablero [0][1] && tablero [0][1] == tablero [0][2]) {
			//primera
			return true;
		} else if (tablero[1][0]== tablero [1][1] && tablero [1][1] == tablero [1][2]) {
			//segunda
			return true;

		} else if (tablero[2][0]== tablero [2][1] && tablero [2][1] == tablero [2][2]) {
			//segunda
			return true;

		} else if (tablero[0][0]== tablero [1][0] && tablero [1][0] == tablero [2][0]) {
			//segunda
			return true;

		}  else if (tablero[1][0]== tablero [1][1] && tablero [1][1] == tablero [1][2]) {
			//segund
			return true;

		} else if (tablero[2][0]== tablero [2][1] && tablero [2][1] == tablero [2][2]) {
			//segunda
			return true;

		} else if (tablero[0][0]== tablero [1][1] && tablero [1][1] == tablero [2][2]) {
			//segunda
			return true;

		} else if (tablero[2][0]== tablero [1][1] && tablero [1][1] == tablero [0][2]) {
			//segunda
			return true;

		}else {
			return false;
		}
	}
}

