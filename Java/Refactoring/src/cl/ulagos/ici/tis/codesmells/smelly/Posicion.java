package cl.ulagos.ici.tis.codesmells.smelly;

public class Posicion
{
    private final int _row;
    private final int _column;

    public Posicion(int row, int column)
    {
        _row = row;
        _column = column;
    }

    public int getRow()
    {
        return _row;
    }

    public int getColumn()
    {
        return _column;
    }

    @Override
    public String toString()
    {
        return "(ROW: " + _row + ", COLUMN: " + _column + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Posicion))
            return false;
        Posicion otherPosicion = (Posicion) obj;
        return this == obj || (_row == otherPosicion.getRow() && _column == otherPosicion.getColumn());
    }
}
