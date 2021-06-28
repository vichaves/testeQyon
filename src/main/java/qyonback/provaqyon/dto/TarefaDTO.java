package qyonback.provaqyon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import qyonback.provaqyon.domain.TarefaStatusEnum;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private TarefaStatusEnum status;
    private Instant dataExecucao;
}
