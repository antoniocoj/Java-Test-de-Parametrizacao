package app;

public class CalcularTaxiTarifa {

	public static float calculoTarifa(String bandeirada, int km, int hora) {
		float valor = 0.00f;

		if (km != 0) {
			if (bandeirada != null){
				if (bandeirada == "Bandeira 1") {
					valor = 5.24f + (km * 2.85f) + (31.72f * hora);
				} else if (bandeirada == "Bandeira 2") {
					valor = 5.24f + (km * 3.66f) + (31.72f * hora);
				}
			} else {

			}
		} else {

		}
		return valor;
	}
}
