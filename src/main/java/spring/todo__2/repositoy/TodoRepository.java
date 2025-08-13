package spring.todo__2.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.todo__2.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByIdAndUser_Password(Long id, String userPassword);
}
