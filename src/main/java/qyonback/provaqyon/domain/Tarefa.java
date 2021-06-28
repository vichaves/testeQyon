package qyonback.provaqyon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import qyonback.provaqyon.dto.TarefaDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private TarefaStatusEnum status;

    private Instant dataExecucao;

    public Tarefa dtoToEntity(TarefaDTO tarefaDTO){
        return Tarefa.builder()
                .id(tarefaDTO.getId())
                .nome(tarefaDTO.getNome())
                .descricao(tarefaDTO.getDescricao())
                .status(tarefaDTO.getStatus())
                .dataExecucao(tarefaDTO.getDataExecucao())
                .build();
    }
}
