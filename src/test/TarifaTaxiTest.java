package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.CalcularTaxiTarifa;

@RunWith(Parameterized.class)
public class TarifaTaxiTest {

	String bandeirada;
	int km;
	int hora;
	float valor;
	
	public TarifaTaxiTest (String bandeirada, int km, int hora, float valor) {
		this.bandeirada = bandeirada;
		this.km = km;
		this.hora = hora;
		this.valor = valor;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"Bandeira 1",100,0,290.24f},
			{"Bandeira 2",100,0,371.24f},
			{"Bandeira 1",50,1,179.46f},
			{"Bandeira 2",50,1,219.96f},
			{"Bandeira 1",30,1,122.46f},
			{"Bandeira 2",30,2,178.48f}
		});
	}
	@Test
	public void testCalculoTaxiDF(){
		assertEquals(valor, CalcularTaxiTarifa.calculoTarifa(bandeirada, km, hora), 0.01f);
	}

}
