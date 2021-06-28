package qyonback.provaqyon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import qyonback.provaqyon.domain.TarefaStatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaUpdateDTO {
    private Integer id;
    private TarefaStatusEnum status;
}
