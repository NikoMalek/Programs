package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public class Rey extends Pieza
{
    public Rey(Color color)
    {
        super(color, 'K');
    }

    @Override
    public String toString()
    {
        return "K";
    }
}
