package cl.ulagos.ici.tis.codesmells.smelly.ajedrez;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Pieza;

public class Celda
{
    private Pieza _pieza;
    private Color _color;

    public Celda(Color color)
    {
        _color = color;
    }

    public void removerPieza()
    {
        _pieza = null;
    }

    public Pieza getPieza()
    {
        return _pieza;
    }

    public void setPieza(Pieza pieza)
    {
        _pieza = pieza;
    }

    public boolean isEmpty()
    {
        return _pieza == null;
    }

    @Override
    public String toString()
    {
        return _pieza == null
                ? ("." + _color + ".")
                : (_pieza.getColor().toString() + _color + _pieza.toString());
    }
}
