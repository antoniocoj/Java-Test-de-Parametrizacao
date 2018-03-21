package das.iprf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Rendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double valor;

    public Rendimento(Double valor) {
        this.valor = valor;
    }
}
