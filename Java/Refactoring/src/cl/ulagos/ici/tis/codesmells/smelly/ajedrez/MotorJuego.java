package cl.ulagos.ici.tis.codesmells.smelly.ajedrez;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.Posicion;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.*;

import java.util.Scanner;

import cl.ulagos.ici.tis.codesmells.smelly.piezas.AlfilDerecho;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.AlfilIzquierdo;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.CaballoDerecho;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.CaballoIzquierdo;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Peon;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Reina;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Rey;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.TorreDerecha;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.TorreIzquierda;

public class MotorJuego
{
    private static final Scanner scanner = new Scanner(System.in);
    private final TableroAjedrez _tableroAjedrez;
    private Jugador _jugador1, _jugador2;
    private Jugador _currentJugador;

    public MotorJuego(Jugador jugador1, Jugador jugador2)
    {
        _tableroAjedrez = new TableroAjedrez();
        _jugador1 = jugador1;
        _jugador2 = jugador2;
        resetearTablero();
    }

    public void inicializarJuego()
    {
        if (_currentJugador == null || _jugador1.getColor() == Color.BLACK) {
            _currentJugador = _jugador1;
            _jugador1.setColor(Color.WHITE);
            _jugador2.setColor(Color.BLACK);
        } else {
            _currentJugador = _jugador2;
            _jugador1.setColor(Color.BLACK);
            _jugador2.setColor(Color.WHITE);
        }
        System.out.println("\nJuego inicializado");
        System.out.println("Jugador " + _jugador1.getNombre() + " tiene el Color " + _jugador1.getColor());
        System.out.println("Jugador " + _jugador2.getNombre() + " tiene el Color " + _jugador2.getColor());
        System.out.println("");
        resetearTablero();
        System.out.println(_tableroAjedrez);
    }

    public void comenzarJuego()
    {
        while (true) {
            System.out.println("El siguiente movimiento es de " + _currentJugador.getNombre()
                               + " [" + _currentJugador.getColor() + "]");
            System.out.print("Ingresar una posicion (fila columna) de la pieza a mover: ");
            Posicion from = posicionEntrada();
            System.out.print("Ingresar una posicion de destino: ");
            Posicion to = posicionEntrada();
            Movimiento movimiento = new Movimiento(from, to);
            if (isValidMove(movimiento)) {
                hacerMovimiento(movimiento);
            } else {
                System.out.println("Movimiento invalido!");
            }
        }
    }

    private Posicion posicionEntrada()
    {
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;
        return new Posicion(row, col);
    }

    public void resetearTablero()
    {
        for (int column = 0; column < 8; column++) {
            if (column == 0) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new TorreIzquierda(Color.WHITE));
            } else if (column == 1) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new CaballoIzquierdo(Color.WHITE));
            } else if (column == 2) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new AlfilIzquierdo(Color.WHITE));
            } else if (column == 3) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new Rey(Color.WHITE));
            } else if (column == 4) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new Reina(Color.WHITE));
            } else if (column == 5) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new AlfilDerecho(Color.WHITE));
            } else if (column == 6) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new CaballoDerecho(Color.WHITE));
            } else if (column == 7) {
                _tableroAjedrez.getTablero()[7][column].setPieza(new TorreDerecha(Color.WHITE));
            }
        }
        for (int column = 0; column < 8; column++) {
            _tableroAjedrez.getTablero()[6][column].setPieza(new Peon(Color.WHITE));
        }

        for (int column = 0; column < 8; column++) {
            if (column == 0) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new TorreIzquierda(Color.BLACK));
            } else if (column == 1) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new CaballoIzquierdo(Color.BLACK));
            } else if (column == 2) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new AlfilIzquierdo(Color.BLACK));
            } else if (column == 3) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new Rey(Color.BLACK));
            } else if (column == 4) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new Reina(Color.BLACK));
            } else if (column == 5) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new AlfilDerecho(Color.BLACK));
            } else if (column == 6) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new CaballoDerecho(Color.BLACK));
            } else if (column == 7) {
                _tableroAjedrez.getTablero()[0][column].setPieza(new TorreDerecha(Color.BLACK));
            }
        }
        for (int column = 0; column < 8; column++) {
            _tableroAjedrez.getTablero()[1][column].setPieza(new Peon(Color.BLACK));
        }

        _tableroAjedrez._kingDead = false;
    }

    private void finJuego()
    {
        System.out.println("Juego Terminado");
        Jugador ganador = _currentJugador;
        ganador.aumentar();
        System.out.println("Ganador - " + ganador + "\n\n");
    }

    private Jugador getOtroJugador()
    {
        return _jugador1 == _currentJugador ? _jugador2 : _jugador1;
    }

    public void hacerMovimiento(Movimiento movimiento)
    {
        _tableroAjedrez.moverPieza(movimiento.getFrom().getRow(), movimiento.getFrom().getColumn(), movimiento.getTo().getRow(),
                movimiento.getTo().getColumn());
        System.out.println("");
        System.out.println(_tableroAjedrez);
        if (_tableroAjedrez.esReyMuerto()) {
            finJuego();
            inicializarJuego();
        } else {
            _currentJugador = getOtroJugador();
        }
    }

    public boolean isValidMove(Movimiento movimiento)
    {
        return isPlayerMovingItsOwnColoredPiece(movimiento.getFrom())
               && _tableroAjedrez.esMovimientoValido(movimiento.getFrom().getRow(), movimiento.getFrom().getColumn(),
            movimiento.getTo().getRow(), movimiento.getTo().getColumn());
    }

    private boolean isPlayerMovingItsOwnColoredPiece(Posicion from) {
        return !_tableroAjedrez.isEmpty(from)
               && _tableroAjedrez.getPieza(from).getColor() == _currentJugador.getColor();
    }

    public TableroAjedrez getChessBoard()
    {
        return _tableroAjedrez;
    }
}
