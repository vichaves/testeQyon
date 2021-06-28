package qyonback.provaqyon.ropository;

import org.springframework.data.jpa.repository.JpaRepository;
import qyonback.provaqyon.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
