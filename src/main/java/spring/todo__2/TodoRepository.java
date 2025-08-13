package spring.todo_2.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.todo_2.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    boolean existsByIdAndPassword(Long id, String password);
}
