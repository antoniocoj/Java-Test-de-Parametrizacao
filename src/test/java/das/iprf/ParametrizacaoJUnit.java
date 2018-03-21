package das.iprf;

import das.iprf.controller.AliquotaIRPF;
import das.iprf.controller.BaseIRPF;
import das.iprf.model.Pessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizacaoJUnit {

    private Double rendimento1;
    private Double rendimento2;
    private Double rendimento3;

    private Double despesa1;
    private Double despesa2;
    private Double despesa3;

    private Integer qtdDependentes;

    private Double impostoDeRenda;

    /*
     * Construtor para ligar os dados passados pelo Data Driven ao script
     */
    public ParametrizacaoJUnit(Double rendimento1, Double rendimento2, Double rendimento3,
                               Double despesa1, Double despesa2, Double despesa3,
                               Integer qtdDependentes, Double impostoDeRenda) {
        this.rendimento1 = rendimento1;
        this.rendimento2 = rendimento2;
        this.rendimento3 = rendimento3;
        this.despesa1 = despesa1;
        this.despesa2 = despesa2;
        this.despesa3 = despesa3;
        this.qtdDependentes = qtdDependentes;
        this.impostoDeRenda = impostoDeRenda;
    }

    @Test
    public void testeParametrizacaoJUnit() {
        Pessoa pessoa = new Pessoa(2);

        pessoa.addRedimento(rendimento1);
        pessoa.addRedimento(rendimento2);
        pessoa.addRedimento(rendimento3);

        pessoa.addDespesa(despesa1);
        pessoa.addDespesa(despesa2);
        pessoa.addDespesa(despesa3);

        BaseIRPF baseIRPF = new BaseIRPF(pessoa);

        Double impostoDeRenda = AliquotaIRPF.getImpostoDeRenda(baseIRPF.getBase());

        assertEquals(impostoDeRenda, this.impostoDeRenda);
    }

    /*
     * Método que leva o Data Driven ao script
     */
    @Parameterized.Parameters(name = "{index}: {0}|{1}|{2}|{3}{4}{5}{6}{7}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // redimento, redimento, rendimento, despesa, despesa, despesa, dependentes, impostoDeRenda
                {500.00, 500.00, 100.00, 500.00, 200.00, 0.00, 5, 0.00}, // Faixa 1
                {1500.00, 1200.00, 1000.00, 100.00, 200.00, 300.00, 3, 61.26}, // Faixa 2
                {4000.00, 1500.00, 0.00, 1000.00, 700.00, 200.00, 1, 128.45}, // Faixa 3
                {4500.00, 3000.00, 1500.00, 2000.00, 1500.00, 600.00, 2, 381.19}, // Faixa 4
                {5000.00, 1500.00, 1000.00, 1000.00, 300.00, 600.00, 2, 565.59}, // Faixa 5
        });
    }
}
