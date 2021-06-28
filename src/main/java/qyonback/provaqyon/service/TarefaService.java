package qyonback.provaqyon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import qyonback.provaqyon.domain.Tarefa;
import qyonback.provaqyon.requests.TarefaPostRequestBody;
import qyonback.provaqyon.requests.TarefaPutRequestBody;
import qyonback.provaqyon.ropository.TarefaRepository;
import qyonback.provaqyon.util.DateUtil;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final DateUtil dateUtil;
    private final TarefaRepository tarefaRepository;

    public List<Tarefa> listAll(){
        return tarefaRepository.findAll();
    }

    public Tarefa findByIdOrThrowBadRequestException(Integer id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarefa não existe"));
    }

    public Tarefa save(TarefaPostRequestBody tarefaPostRequestBody){
        return tarefaRepository.save(Tarefa.builder()
                .nome(tarefaPostRequestBody.getNome())
                .descricao(tarefaPostRequestBody.getDescricao())
                .status("Não iniciado")
                .data(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()))
                .build());
    }

    public void delete(Integer id){
        tarefaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(TarefaPutRequestBody tarefaPutRequestBody){
        Tarefa tarefaSalva = findByIdOrThrowBadRequestException(tarefaPutRequestBody.getId());
        Tarefa tarefa = Tarefa.builder()
                .id(tarefaSalva.getId())
                .nome(tarefaSalva.getNome())
                .descricao(tarefaSalva.getDescricao())
                .status(tarefaPutRequestBody.getStatus())
                .data(tarefaSalva.getData())
                .build();
        tarefaRepository.save(tarefa);
    }
}
