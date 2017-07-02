package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Pedido;

public interface FarmaciaDao {
	void guardarFarmaciaNueva (Farmacia farmacia);
	
	Farmacia consultarFarmacia (Farmacia farmacia);
	
	Farmacia consultarFarmaciaPorId (Integer idFarmacia);
	
	List<Pedido> obtenerPedidosPorFarmacia(Integer idFarmacia);

}
