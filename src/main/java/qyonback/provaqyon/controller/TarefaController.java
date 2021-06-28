package qyonback.provaqyon.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qyonback.provaqyon.domain.Tarefa;
import qyonback.provaqyon.dto.TarefaDTO;
import qyonback.provaqyon.dto.TarefaUpdateDTO;
import qyonback.provaqyon.service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("tarefas")
@AllArgsConstructor
public class TarefaController {
    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> list(){
        return ResponseEntity.ok(tarefaService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Integer id){
        return ResponseEntity.ok(tarefaService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Tarefa> save(@RequestBody TarefaDTO tarefaDTO){
        return new ResponseEntity<>(tarefaService.save(tarefaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        tarefaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TarefaUpdateDTO tarefaUpdateDTO){
        tarefaService.replace(tarefaUpdateDTO.getId(), tarefaUpdateDTO.getStatus());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
