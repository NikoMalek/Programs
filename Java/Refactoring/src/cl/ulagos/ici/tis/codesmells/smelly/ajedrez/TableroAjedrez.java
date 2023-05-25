package cl.ulagos.ici.tis.codesmells.smelly.ajedrez;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.Direccion;
import cl.ulagos.ici.tis.codesmells.smelly.Posicion;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Rey;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Caballo;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Peon;
import cl.ulagos.ici.tis.codesmells.smelly.piezas.Pieza;

public class TableroAjedrez
{
    private final Celda[][] _board;
    public boolean _kingDead;
    public Jugador _jugador1, _jugador2;

    public TableroAjedrez()
    {
        _board = new Celda[8][8];
        inicializarTablero();
    }

    private void inicializarTablero()
    {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                Color color = ((row + column) % 2 == 0) ? Color.WHITE : Color.BLACK;
                _board[row][column] = new Celda(color);
            }
        }
    }

    public Celda[][] getTablero()
    {
        return _board;
    }

    private boolean esPosicionFueraBorde(Posicion posicion)
    {
        return (posicion.getRow() < 0
                || posicion.getRow() >= 8
                || posicion.getColumn() < 0
                || posicion.getColumn() >= 8);
    }

    public boolean isEmpty(Posicion posicion)
    {
        return esPosicionFueraBorde(posicion) || getCelda(posicion).isEmpty();
    }

    private Celda getCelda(Posicion posicion)
    {
        return _board[posicion.getRow()][posicion.getColumn()];
    }

    public Pieza getPieza(Posicion posicion)
    {
        return (esPosicionFueraBorde(posicion) || getCelda(posicion).isEmpty())
                ? null
                : getCelda(posicion).getPieza();
    }

    public String getPlayerName(Posicion posicion)
    {
        if (esPosicionFueraBorde(posicion))
            return null;
        Color color = getCelda(posicion).getPieza().getColor();
        if (color == _jugador1.getColor()) {
            return _jugador1.getNombre();
        } else {
            return _jugador2.getNombre();
        }
    }

    private void imprimirMovimiento(Posicion from, Posicion to)
    {
        System.out.println(getPlayerName(from) + " movido " + getPieza(from) + " from " + from + " to " + to);
        if (getPieza(from).getColor() != getPieza(to).getColor()) {
            System.out.println("Y ha capturado " + getPieza(to) + " de " + getPlayerName(to));
        }
    }

    public boolean esMovimientoValido(int fromRow, int fromColumn, int toRow, int toColumn)
    {
        Posicion from = new Posicion(fromRow, fromColumn);
        Posicion to = new Posicion(toRow, toColumn);
        return !from.equals(to)
               && !(esPosicionFueraBorde(from) || esPosicionFueraBorde(to))
               && !isEmpty(from)
               && (isEmpty(to) || getPieza(from).getColor() != getPieza(to).getColor())
               && getPieza(from).esMovimientoValido(from, to)
               && noExistePiezaCamino(from, to)
               && (!(getPieza(from) instanceof Peon) || esMovimientoPeonValida(from, to));
    }

    private boolean noExistePiezaCamino(Posicion from, Posicion to)
    {
        if (getPieza(from) instanceof Caballo)
            return true;
        if (!isStraightLineMove(from, to))
            return false;
        Direccion direccion = new Direccion(ComparaTope(to.getRow(), from.getRow()), ComparaTope(to.getColumn(), from.getColumn()));
        from = trasladarPosicion(from, direccion);
        while (!from.equals(to)) {
            if (!isEmpty(from))
                return false;
            from = trasladarPosicion(from, direccion);
        }
        return true;
    }

    private boolean isStraightLineMove(Posicion from, Posicion to)
    {
        return Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn())
                || from.getRow() == to.getRow()
                || from.getColumn() == to.getColumn();
    }

    private int ComparaTope(int x, int y)
    {
        return Math.max(-1, Math.min(1, Integer.compare(x, y)));
    }

    private Posicion trasladarPosicion(Posicion from, Direccion direccion)
    {
        return new Posicion(from.getRow() + direccion.getRowOffset(), from.getColumn() + direccion.getColumnOffset());
    }

    public void moverPieza(int fromRow, int fromColumn, int toRow, int toColumn)
    {
        Posicion from = new Posicion(fromRow, fromColumn);
        Posicion to = new Posicion(toRow, toColumn);
        actualizarEsReyMuerto(toRow, toColumn);
        if (!getCelda(to).isEmpty())
            getCelda(to).removerPieza();
        getCelda(to).setPieza(getPieza(from));
        getCelda(from).removerPieza();
    }

    private void actualizarEsReyMuerto(int row, int column)
    {
        if (getPieza(new Posicion(row, column)) instanceof Rey) {
            _kingDead = true;
        }
    }

    private boolean esMovimientoPeonValida(Posicion from, Posicion to)
    {
        assert getPieza(from) instanceof Peon;
        Peon peon = (Peon)getPieza(from);
        Color pawnColor = peon.getColor();
        int forwardRow = from.getRow() + ((pawnColor == Color.BLACK) ? 1 : -1);
        Posicion forwardLeft = new Posicion(forwardRow, from.getColumn() + (pawnColor == Color.WHITE ? -1 : 1));
        Posicion forwardRight = new Posicion(forwardRow, from.getColumn() + (pawnColor == Color.WHITE ? 1 : -1));

        boolean opponentPieceAtForwardLeft = !isEmpty(forwardLeft) && getPieza(forwardLeft).getColor() != pawnColor;
        boolean opponentPieceAtForwardRight = !isEmpty(forwardRight) && getPieza(forwardRight).getColor() != pawnColor;
        boolean atInitialPosition = from.getRow() == ((pawnColor == Color.BLACK) ? 1 : 6);

        return peon.isValidMoveGivenContext(from, to, atInitialPosition, opponentPieceAtForwardLeft, opponentPieceAtForwardRight);
    }

    public boolean esReyMuerto()
    {
        return _kingDead;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder(" ");
        for (int column = 0; column < 8; column++) {
            stringBuilder.append("  ")
                    .append(column + 1)
                    .append("  ");
        }
        stringBuilder.append("\n");

        for (int row = 0; row < 8; row++) {
            stringBuilder.append(row + 1);
            for (int column = 0; column < 8; column++) {
                stringBuilder.append(" ")
                        .append(_board[row][column])
                        .append(" ");
            }
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }
}
