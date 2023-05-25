package com.directi.trainining.codesmells;

import cl.ulagos.ici.tis.codesmells.smelly.Posicion;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.TableroAjedrez;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.MotorJuego;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.Movimiento;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.Jugador;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Caballo;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Peon;

import org.junit.Before;
import org.junit.Test;
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
        Posicion from = new Posicion(6, 1); // Fila, Columna de la pieza
        Posicion to = new Posicion(4, 1); // Intentar mover a fila , columna

        assertTrue(esMovimientoValidoHelper(from, to));
    }

    @Test
    public void testMovimientoPeonPrimerJugador()
    {
        Posicion from = new Posicion(6, 1); // Fila, Columna de la pieza
        Posicion to = new Posicion(4, 1); // Intentar mover a fila , columna

        boolean haceM
        assertTrue(hacerMovimientoHelper(from, to););
    }
/*
    @Test
    public void testEsMovimientoValidoCaballoSegundoJugador()
    {

    }

    @Test
    public void testMovimientoCaballoSegundoJugador()
    {

    }

    @Test
    public void testMovimientoInvalidoPeon()
    {

    }

    @Test
    public void testMovimientoInvalidoPiezaEntreMedio()
    {

    }

    @Test
    public void testMovimientoPiezaLugarOcupado()
    {

    }*/
}
