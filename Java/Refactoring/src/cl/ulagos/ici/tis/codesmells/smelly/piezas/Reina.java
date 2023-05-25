package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;

public class Reina extends Pieza
{
    public Reina(Color color)
    {
        super(color, 'q');
    }

    @Override
    public String toString()
    {
        return "q";
    }
}
