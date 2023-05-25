package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.Posicion;

public abstract class Pieza
{
    public Color _color;
    public char _type;

    public Pieza(Color color, char type)
    {
        _color = color;
        _type = type;
    }

    public Color getColor()
    {
        return _color;
    }

    public boolean esMovimientoValido(Posicion from, Posicion to)
    {
        switch (_type) {
            case 'b':
                return Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn());
            case 'r':
                return from.getRow() == to.getRow() || from.getColumn() == to.getColumn();
            case 'k':
                int columnDiff = Math.abs(to.getColumn() - from.getColumn());
                int rowDiff = Math.abs(to.getRow() - from.getRow());
                return (columnDiff == 2 && rowDiff == 1) || (columnDiff == 1 && rowDiff == 2);
            case 'q':
                return Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn())
                        || from.getRow() == to.getRow() || from.getColumn() == to.getColumn();
            case 'K':
                return (Math.abs(from.getRow() - to.getRow()) == 1) && (Math.abs(from.getColumn() - to.getColumn()) == 1);
            default:
                return false;
        }
    }
}
