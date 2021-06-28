package qyonback.provaqyon.requests;

import lombok.Data;

@Data
public class TarefaPostRequestBody {
    private String nome;
    private String descricao;
}
