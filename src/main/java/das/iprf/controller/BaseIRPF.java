package das.iprf.controller;

import lombok.Getter;
import lombok.Setter;
import das.iprf.model.Pessoa;

@Getter
@Setter
public class BaseIRPF {

    private Double base;

    public BaseIRPF(Pessoa pessoa) {
        Double totalRendimento = pessoa.getTotalRendimentos();
        Double totalDeducoes = pessoa.getTotalDespesas() + pessoa.getTotalDependentes();

        this.base = totalRendimento - totalDeducoes;
    }
}
