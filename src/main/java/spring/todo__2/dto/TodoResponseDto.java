package spring.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final Long id;

    private final String title;
    //일정 제목
    private final String detail;
    //일정 내용
    private final String name;
    //일정 작성자명
    private final LocalDateTime createdAt;
    //일정 작성/수정일
    private final LocalDateTime modifiedAt;

    public TodoResponseDto(Long id, String title, String detail, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
//비밀번호를 넣어야 하는데 어떻게 구동하는지 모르겠음 과연 어떻게 해야할까 계속 하다가 내일 묻기로