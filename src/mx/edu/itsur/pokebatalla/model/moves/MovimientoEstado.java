package mx.edu.itsur.pokebatalla.model.moves;

import mx.edu.itsur.pokebatalla.model.Pokemons.Pokemon;

/**
 *
 * @author Francisco Gonzalez Regalado
 */
public class MovimientoEstado extends Movimiento{
    
    @Override
    public void utilizar(Pokemon usuario, Pokemon objetivo){
        
        int nivelAtacante = usuario.getNivel();
        int ataqueAtacante = usuario.getAtaque();
        int poderMovimiento = this.puntosPoder;;
        int defensaObjetivo = objetivo.getDefensa();

        double modificador = 0.0;
        
        int danio = (int) (modificador);
        
        objetivo.recibirDanio(danio); 

        System.out.println(usuario.getClass().getSimpleName() + " USA MOVIMIENTO ESTADO " + this.getClass().getSimpleName() 
                + "\n A " + objetivo.getClass().getSimpleName() + " Y CAUSA DANIO DE " + danio);
        
    }
}
