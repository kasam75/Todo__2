package spring.todo.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
    //데이터 베이스에서 불러오는 아이디
    private String title;
    //일정 제목
    private String detail;
    //일정 내용
    private String name;
    //        일정 작성자명
    private String password;
    //페스워드
}
//아이디와 베이스 엔티티에 적은것은 쓰지 않아도 됨
//쓰기전에 무엇을 하는지,쓰고나서 잘썻는지 확인
