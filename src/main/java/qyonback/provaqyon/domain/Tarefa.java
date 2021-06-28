package qyonback.provaqyon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import qyonback.provaqyon.requests.TarefaDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    private String data;

    public Tarefa dtoToEntity(TarefaDTO tarefaDTO){
        return Tarefa.builder()
                .id(tarefaDTO.getId())
                .nome(tarefaDTO.getNome())
                .descricao(tarefaDTO.getDescricao())
                .status(tarefaDTO.getStatus())
                .data(tarefaDTO.getData())
                .build();
    }
}
