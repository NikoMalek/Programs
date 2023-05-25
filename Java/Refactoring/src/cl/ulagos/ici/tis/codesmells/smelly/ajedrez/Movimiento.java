package cl.ulagos.ici.tis.codesmells.smelly.ajedrez;

import cl.ulagos.ici.tis.codesmells.smelly.Posicion;

public class Movimiento
{
    private Posicion _from, _to;

    public Movimiento(Posicion from, Posicion to)
    {
        _from = from;
        _to = to;
    }

    public Posicion getFrom()
    {
        return _from;
    }

    public Posicion getTo()
    {
        return _to;
    }
}
