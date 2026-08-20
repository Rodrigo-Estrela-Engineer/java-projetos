package com.example.projeto_spring.infrastructure.repository;

import com.example.projeto_spring.domain.Task;
import com.example.projeto_spring.domain.TaskId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InMemoryTaskRepositoryTest {

    @InjectMocks
    private InMemoryTaskRepository repository;

    @Mock
    private Task task1;

    @Mock
    private Task task2;

    @Mock
    private TaskId id1;

    @Mock
    private TaskId id2;

    @Test
    @DisplayName("Deve salvar e retornar uma nova tarefa")
    void deveSalvarTarefaComSucesso() {
        
        when(task1.getId()).thenReturn(id1);

        
        Task savedTask = repository.save(task1);

        
        assertThat(savedTask).isNotNull().isEqualTo(task1);
        
        Optional<Task> foundTask = repository.findById(id1);
        assertThat(foundTask).isPresent().contains(task1);
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia quando não houver tarefas")
    void deveRetornarListaVaziaQuandoNaoHouverTarefas() {
        
        List<Task> tasks = repository.findAll();

        
        assertThat(tasks).isEmpty();
    }

    @Test
    @DisplayName("Deve retornar todas as tarefas salvas")
    void deveRetornarTodasAsTarefasSalvas() {
       
        when(task1.getId()).thenReturn(id1);
        when(task2.getId()).thenReturn(id2);

        repository.save(task1);
        repository.save(task2);

        List<Task> tasks = repository.findAll();

       
        assertThat(tasks)
                .hasSize(2)
                .containsExactlyInAnyOrder(task1, task2);
    }

    @Test
    @DisplayName("Deve retornar Optional vazio ao buscar ID inexistente")
    void deveRetornarVazioQuandoIdNaoExistir() {
       
        Optional<Task> foundTask = repository.findById(id1);

        
        assertThat(foundTask).isEmpty();
    }

    @Test
    @DisplayName("Deve deletar uma tarefa existente por ID")
    void deveDeletarTarefaComSucesso() {
        
        when(task1.getId()).thenReturn(id1);
        repository.save(task1);

        
        repository.delete(id1);

        
        Optional<Task> foundTask = repository.findById(id1);
        assertThat(foundTask).isEmpty();
        assertThat(repository.findAll()).isEmpty();
    }
}
