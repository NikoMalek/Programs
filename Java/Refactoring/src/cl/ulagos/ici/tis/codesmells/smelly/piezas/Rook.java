package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public abstract class Rook extends Pieza
{
    public Rook(Color color)
    {
        super(color, 'r');
    }

    @Override
    public String toString()
    {
        return "r";
    }
}
