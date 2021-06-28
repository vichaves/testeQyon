package qyonback.provaqyon.requests;

import lombok.Data;

import java.util.Date;

@Data
public class TarefaPutRequestBody {
    private Integer id;
    private String nome;
    private String descricao;
    private String status;
    private Date data;
}
