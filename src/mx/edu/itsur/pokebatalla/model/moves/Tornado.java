package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Tornado extends MovimientoEspecial{
    
    public Tornado() {
        this.tipo=Movimiento.TiposDeMovimiento.VOLADOR;
        this.potencia = 80;
        this.precision = 100;
        this.puntosPoder = 25;
    }
}