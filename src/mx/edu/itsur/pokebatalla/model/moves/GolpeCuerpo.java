package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class GolpeCuerpo extends MovimientoFisico{
    
    public GolpeCuerpo() {
        this.tipo=TiposDeMovimiento.NORMAL;
        this.potencia = 85;
        this.precision = 100;
        this.puntosPoder = 15;
    }
        
}