package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;


public interface ServicioFarmacia {
	Farmacia ingresarFarmaciaNueva(Farmacia farmacia);

	Farmacia logear(Farmacia farmacia);
}
