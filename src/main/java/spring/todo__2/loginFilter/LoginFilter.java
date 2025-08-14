package spring.todo__2.loginFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {
    // 인증을 하지 않아도될 URL Path 배열
    private static final String[] WHITE_LIST = {"/", "/signup", "/login","/users/**"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //ServletRequest 객체를 더 구체적인 HttpServletRequest 객체로 형 변환.
        // HTTP 요청의 URL, 헤더, 세션 정보 등을 사용하려면 이 변환이 필요
        String requestURI = httpRequest.getRequestURI();
        //들어온 요청의 **URI(Uniform Resource Identifier)**를 가져와 requestURI 변수에 저장합니다. 예를 들어, http://localhost:8080/mypage 요청의 URI는 /mypage가 됩니다
        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            // 로그인하지 않은 사용자인 경우
            if (session == null || session.getAttribute("LOGIN_DIRECTOR") == null) {
                throw new RuntimeException("로그인 해주세요.");
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}