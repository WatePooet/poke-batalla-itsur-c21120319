package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class AtaqueRapido extends MovimientoFisico{
    
    public AtaqueRapido() {
        this.tipo=TiposDeMovimiento.NORMAL;
        this.potencia = 40;
        this.precision = 100;
        this.puntosPoder = 30;
    }
        
}
