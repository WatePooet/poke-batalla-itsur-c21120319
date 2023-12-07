package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Rayo extends MovimientoEspecial{
    
    public Rayo() {
        this.tipo = TiposDeMovimiento.ELECTRICO;
        this.potencia = 90;
        this.precision = 100;
        this.puntosPoder = 15;

    } 
}
