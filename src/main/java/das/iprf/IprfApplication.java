package das.iprf;

import das.iprf.controller.AliquotaIRPF;
import das.iprf.controller.BaseIRPF;
import das.iprf.model.Pessoa;

public class IprfApplication {

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa(2);

		pessoa.addRedimento(5000.00 );
		pessoa.addRedimento(1500.00);
		pessoa.addRedimento(1000.00);

		pessoa.addDespesa(1000.00);
		pessoa.addDespesa(300.00);
		pessoa.addDespesa(600.00);

		BaseIRPF baseIRPF = new BaseIRPF(pessoa);

		Double impostoDeRenda = AliquotaIRPF.getImpostoDeRenda(baseIRPF.getBase());

		System.out.println("O Valor do Imposto de Renda é: R$ " + impostoDeRenda + ".\n");
	}
}
