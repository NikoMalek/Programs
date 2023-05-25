package cl.ulagos.ici.tis.codesmells.smelly.ajedrez;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public class Jugador
{
    private String _name;
    private int _gamesWon;
    private Color _color;

    public Jugador(String name)
    {
        _name = name;
        _gamesWon = 0;
    }

    public String getNombre()
    {
        return _name;
    }

    public void aumentar()
    {
        _gamesWon++;
    }

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color color)
    {
        _color = color;
    }

    @Override
    public String toString()
    {
        return "NAME: " + _name + "; GAMES WON: " + _gamesWon;
    }
}
