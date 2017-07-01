package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public interface FarmaciaDao {
	void guardarFarmaciaNueva (Farmacia farmacia);
	
	Farmacia consultarFarmacia (Farmacia farmacia);
	
	Farmacia consultarFarmaciaPorId (Integer idFarmacia);
}
