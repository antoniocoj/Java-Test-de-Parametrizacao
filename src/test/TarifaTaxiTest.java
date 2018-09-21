package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.CalcularTaxiTarifa;

public class TarifaTaxiTest {

	@Test
	public void tarifaTaxiTest() {
		assertEquals(290.24f,CalcularTaxiTarifa.calculoTarifa("Bandeira 1", 100, 0), 0.00f);
		
	}
	
	@Test
	public void tarifaTaxiOutroValorTest() {
		assertEquals(321.96f,CalcularTaxiTarifa.calculoTarifa("Bandeira 1", 100, 1), 0.00f);
		
	}
	
	@Test
	public void tarifaTaxiBandeira2Test() {
		assertEquals(178.48f,CalcularTaxiTarifa.calculoTarifa("Bandeira 2", 30, 2), 0.00f);
		
	}
}
