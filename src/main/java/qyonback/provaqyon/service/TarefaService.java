package qyonback.provaqyon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import qyonback.provaqyon.domain.Tarefa;
import qyonback.provaqyon.domain.TarefaStatusEnum;
import qyonback.provaqyon.requests.TarefaDTO;
import qyonback.provaqyon.requests.TarefaPostRequestBody;
import qyonback.provaqyon.requests.TarefaPutRequestBody;
import qyonback.provaqyon.repository.TarefaRepository;
import qyonback.provaqyon.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public Tarefa save(TarefaDTO tarefaDTO){
        if(Objects.nonNull(tarefaDTO.getId())){
            throw new RuntimeException("A tarefa não pode possuir ID, neste caso utilize API de PUT.");
        }
        return tarefaRepository.save(Tarefa.builder()
                .nome(tarefaDTO.getNome())
                .descricao(tarefaDTO.getDescricao())
                .status(TarefaStatusEnum.NAO_INICIADO)
                .data(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()))
                .build());
    }

    public void delete(Integer id){
        tarefaRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(Integer id, TarefaStatusEnum tarefaStatusEnum){
        Tarefa tarefaSalva = findByIdOrThrowBadRequestException(id);
        if(Objects.isNull(tarefaSalva)) {
            throw new RuntimeException("A tarefa não foi encontrada.");
        }
        tarefaSalva.setStatus(tarefaStatusEnum);
        tarefaRepository.save(tarefaSalva);
    }
}
