package spring.todo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByIdAndPassword(Long todoId, String password);
}
