package das.iprf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Double VALOR_POR_DEPENDENTE = 189.59;

    private List<Rendimento> rendimentos = new ArrayList<>();
    private List<Despesa> despesas = new ArrayList<>();
    private Integer qtdDependentes;

    public Pessoa(Integer qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    public Double getTotalRendimentos() {
        Double total = 0.00;

        for (Rendimento r: getRendimentos()) {
            total += r.getValor();
        }

        return total;
    }

    public Double getTotalDespesas() {
        Double total = 0.00;

        for (Despesa r: getDespesas()) {
            total += r.getValor();
        }

        return total;

    }

    public Double getTotalDependentes() {
        return VALOR_POR_DEPENDENTE * getQtdDependentes();
    }

    public void addRedimento(Double redimento) {
        this.rendimentos.add(new Rendimento(redimento));
    }

    public void addDespesa(Double despesa) {
        this.despesas.add(new Despesa(despesa));
    }
}
