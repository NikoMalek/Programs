package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public class Caballo extends Pieza
{
    public Caballo(Color color)
    {
        super(color, 'k');
    }

    @Override
    public String toString()
    {
        return "k";
    }
}
