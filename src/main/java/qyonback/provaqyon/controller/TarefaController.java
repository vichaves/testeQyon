package qyonback.provaqyon.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qyonback.provaqyon.domain.Tarefa;
import qyonback.provaqyon.requests.TarefaPostRequestBody;
import qyonback.provaqyon.requests.TarefaPutRequestBody;
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
    public ResponseEntity<Tarefa> save(@RequestBody TarefaPostRequestBody tarefaPostRequestBody){
        return new ResponseEntity<>(tarefaService.save(tarefaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        tarefaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TarefaPutRequestBody tarefaPutRequestBody){
        tarefaService.replace(tarefaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
