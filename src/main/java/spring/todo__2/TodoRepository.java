package spring.todo__2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    boolean existsByIdAndPassword(Long id, String password);
}
