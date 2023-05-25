package com.directi.trainining.codesmells;

import cl.ulagos.ici.tis.codesmells.smelly.Posicion;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.TableroAjedrez;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.MotorJuego;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.Movimiento;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.Jugador;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Caballo;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Peon;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Pieza;



import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

public class TestJuegoAjedrez
{

    private MotorJuego _motorJuego;

    private boolean esMovimientoValidoHelper(Posicion from, Posicion to) {
        return _motorJuego.isValidMove(new Movimiento(from, to));
    }
    
    private void hacerMovimientoHelper(Posicion from, Posicion to) {
        _motorJuego.hacerMovimiento(new Movimiento(from, to));
    }

    @Before
    public void inicializarJuego()
    {
        Jugador jugador1 = new Jugador("A");
        Jugador jugador2 = new Jugador("B");
        _motorJuego = new MotorJuego(jugador1, jugador2);
        _motorJuego.inicializarJuego();
    }

    @Test
    public void testSinMovimientoPiezaPrimerJugador()
    {
        Posicion from = new Posicion(7, 0); // Fila, Columna de la pieza
        Posicion to = new Posicion(5, 0); // Intentar mover a fila , columna

        assertFalse(esMovimientoValidoHelper(from, to));
    }
    @Test
    public void testSinMovimientoPiezaSegundoJugador()
    {
        hacerMovimientoHelper(new Posicion(7, 0), new Posicion(5,0));
        Posicion from = new Posicion(0, 7); // Fila, Columna de la pieza
        Posicion to = new Posicion(2, 7); // Intentar mover a fila , columna

        assertFalse(esMovimientoValidoHelper(from, to));
    }
    @Test
    public void testEsMovimientoValidoPeonPrimerJugador()
    {
        Posicion from = new Posicion(6, 0); // Fila, Columna de la pieza
        Posicion to = new Posicion(5, 0); // Intentar mover a fila , columna

        assertTrue(_motorJuego.getChessBoard().getPieza(new Posicion(6, 1)) instanceof Peon);
        assertTrue(esMovimientoValidoHelper(from, to));

    }

    @Test
    public void testMovimientoPeonPrimerJugador()
    {
        hacerMovimientoHelper(new Posicion(6, 0), new Posicion(2, 0));

        Pieza pieza = _motorJuego.getChessBoard().getPieza(new Posicion(2, 0));

        assertNotNull(pieza);
        assertTrue(pieza instanceof Peon);
        assertEquals(Color.WHITE, pieza.getColor());

        pieza = _motorJuego.getChessBoard().getPieza(new Posicion(6, 0));
        assertNull(pieza);
    }

    @Test
    public void testEsMovimientoValidoCaballoSegundoJugador()
    {
        hacerMovimientoHelper(new Posicion(7, 1), new Posicion(5, 2));

        hacerMovimientoHelper(new Posicion(0, 1), new Posicion(2, 2));

        Pieza pieza = _motorJuego.getChessBoard().getPieza(new Posicion(2, 2));

        assertNotNull(pieza);
        assertTrue(pieza instanceof Caballo);
        assertEquals(Color.BLACK, pieza.getColor());

        pieza = _motorJuego.getChessBoard().getPieza(new Posicion(2, 0));
        assertNull(pieza);


    }

    @Test
    public void testMovimientoCaballoSegundoJugador()
    {
        hacerMovimientoHelper(new Posicion(7, 1), new Posicion(5, 2));


        Posicion from = new Posicion(0, 1); // Fila, Columna de la pieza
        Posicion to = new Posicion(2, 2); // Intentar mover a fila , columna

        assertTrue(_motorJuego.getChessBoard().getPieza(new Posicion(0, 1)) instanceof Caballo);
        assertTrue(esMovimientoValidoHelper(from, to));

    }

    @Test
    public void testMovimientoInvalidoPeon()
    {
        Posicion from = new Posicion(6, 1); // Fila, Columna de la pieza
        Posicion to = new Posicion(3, 1); // Intentar mover a fila , columna
        assertTrue(_motorJuego.getChessBoard().getPieza(new Posicion(6, 1)) instanceof Peon);
        assertFalse(esMovimientoValidoHelper(from, to));


    }

    @Test
    public void testMovimientoInvalidoPiezaEntreMedio()
    {

    Posicion from = new Posicion(6, 1);
    Posicion to = new Posicion(4, 1);

    _motorJuego.getChessBoard().getTablero()[5][1].setPieza(new Peon(Color.WHITE));

    hacerMovimientoHelper(from, to);

    assertFalse(esMovimientoValidoHelper(from, to));
    assertNull(_motorJuego.getChessBoard().getTablero()[4][1].getPieza());
    assertNotNull(_motorJuego.getChessBoard().getTablero()[5][1].getPieza());
    }
    @Test
    public void testMovimientoPiezaLugarOcupado()
    {

      Posicion from = new Posicion(6, 1);
        Posicion to = new Posicion(4, 1);
        _motorJuego.getChessBoard().getTablero()[4][1].setPieza(new Peon(Color.WHITE));
        hacerMovimientoHelper(from, to);
        assertNotNull(_motorJuego.getChessBoard().getTablero()[6][1].getPieza());
        assertNotNull(_motorJuego.getChessBoard().getTablero()[4][1].getPieza());
    }
}
