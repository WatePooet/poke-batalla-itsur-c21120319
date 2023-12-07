package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class AtaqueAla extends MovimientoFisico{
    
    public AtaqueAla() {
        this.tipo=TiposDeMovimiento.VOLADOR;
        this.potencia = 60;
        this.precision = 100;
        this.puntosPoder = 35;
    }
}