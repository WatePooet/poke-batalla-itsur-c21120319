package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class Cuchillada extends MovimientoFisico{
    
    public Cuchillada() {
        this.tipo=TiposDeMovimiento.NORMAL;
        this.potencia = 70;
        this.precision = 100;
        this.puntosPoder = 20;
    }
        
}
