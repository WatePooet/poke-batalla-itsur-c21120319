package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Derribo extends MovimientoFisico{

    public Derribo() {
        this.tipo=TiposDeMovimiento.NORMAL;
        this.potencia = 90;
        this.precision = 85;
        this.puntosPoder = 20;
    }
}

