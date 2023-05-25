package cl.ulagos.ici.tis.codesmells.smelly.piezas;

import cl.ulagos.ici.tis.codesmells.smelly.Color;
import cl.ulagos.ici.tis.codesmells.smelly.Posicion;



public class Peon extends Pieza
{
    public Peon(Color color)
    {
        super(color, 'p');
    }

    @Override
    public boolean esMovimientoValido(Posicion from, Posicion to)
    {
        int columnsMoved = Math.abs(to.getColumn() - from.getColumn());
        int rowsMoved = Math.abs(to.getRow() - from.getRow());
        return isForwardMove(from, to)
               && ((columnsMoved <= 1 && rowsMoved == 1) || (columnsMoved == 0 && rowsMoved == 2));
    }

    private boolean isForwardMove(Posicion from, Posicion to)
    {
        switch (getColor()) {
            case WHITE:
                return to.getRow() < from.getRow();
            case BLACK:
                return to.getRow() > from.getRow();
            default:
                return false;
        }
    }

    public boolean isValidMoveGivenContext(Posicion from,
                                           Posicion to,
                                           boolean atInitialPosition,
                                           boolean opponentPieceAtForwardLeft,
                                           boolean opponentPieceAtForwardRight)
    {
        return isForwardMove(from, to)
               && isTakingAllowedNumberOfForwardSteps(from, to, atInitialPosition)
               && isTakingAllowedNumberOfSidewaysSteps(from, to, opponentPieceAtForwardLeft, opponentPieceAtForwardRight);
    }

    private boolean isTakingAllowedNumberOfForwardSteps(Posicion from, Posicion to, boolean atInitialPosition)
    {
        int rowsAbsDiff = Math.abs(to.getRow() - from.getRow());
        return rowsAbsDiff > 0 && (rowsAbsDiff <= (atInitialPosition ? 2 : 1));
    }

    private boolean isTakingAllowedNumberOfSidewaysSteps(Posicion from,
                                                         Posicion to,
                                                         boolean opponentPieceAtForwardLeft,
                                                         boolean opponentPieceAtForwardRight)
    {
        int columnsDiff = to.getColumn() - from.getColumn();
        if (columnsDiff == -1)
            return (opponentPieceAtForwardLeft && getColor() == Color.WHITE)
                   || (opponentPieceAtForwardRight && getColor() == Color.BLACK);
        if (columnsDiff == 1) {
            return (opponentPieceAtForwardRight && getColor() == Color.WHITE)
                   || (opponentPieceAtForwardLeft && getColor() == Color.BLACK);
        }
        return columnsDiff == 0;
    }

    @Override
    public String toString()
    {
        return "p";
    }
}
