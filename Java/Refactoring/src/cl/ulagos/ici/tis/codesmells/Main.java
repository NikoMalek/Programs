package cl.ulagos.ici.tis.codesmells;

import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.MotorJuego;
import cl.ulagos.ici.tis.codesmells.smelly.ajedrez.Jugador;

import java.util.Scanner;

public class Main
{
    private static final Scanner scanner = new Scanner(System.in);
    private static MotorJuego sMotorJuego;

    public static void main(String[] args)
    {
        initGameEngine();
        sMotorJuego.inicializarJuego();
        sMotorJuego.comenzarJuego();
    }

    private static void initGameEngine()
    {
        System.out.print("Ingrese el nombre del jugador 1: ");
        Jugador jugador1 = new Jugador(scanner.nextLine());
        System.out.print("Ingrese el nombre del jugador 2: ");
        Jugador jugador2 = new Jugador(scanner.nextLine());
        sMotorJuego = new MotorJuego(jugador1, jugador2);
    }
}
