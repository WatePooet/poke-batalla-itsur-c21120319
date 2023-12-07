package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class LanzaLlamas extends MovimientoEspecial{
    
    public LanzaLlamas() {
        this.tipo=Movimiento.TiposDeMovimiento.FUEGO;
        this.potencia = 90;
        this.precision = 100;
        this.puntosPoder = 15;
    }
}
