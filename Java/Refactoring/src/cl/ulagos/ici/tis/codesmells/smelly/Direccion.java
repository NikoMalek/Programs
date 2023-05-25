package cl.ulagos.ici.tis.codesmells.smelly;

public class Direccion
{
    private final int _rowOffset;
    private final int _columnOffset;

    public Direccion(int rowOffset, int columnOffset) {
        _rowOffset = rowOffset;
        _columnOffset = columnOffset;
    }

    public int getRowOffset()
    {
        return _rowOffset;
    }

    public int getColumnOffset()
    {
        return _columnOffset;
    }
}
