package qyonback.provaqyon.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import qyonback.provaqyon.domain.TarefaStatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private TarefaStatusEnum status;
    private String data;
}
