package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public abstract class Alfil extends Pieza
{

    public Alfil(Color color)
    {
        super(color, 'b');
    }

    @Override
    public String toString()
    {
        return "b";
    }
}
