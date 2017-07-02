package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Pedido;


public interface ServicioFarmacia {
	Farmacia ingresarFarmaciaNueva(Farmacia farmacia);

	Farmacia logear(Farmacia farmacia);
	
	List<Pedido> obtenerPedidosPorFarmacia(Integer idFarmacia);
}
