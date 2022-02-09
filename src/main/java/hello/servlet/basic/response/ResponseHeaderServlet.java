package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        //resp.setHeader("Content-Type", "text/plain; charset=utf-8");
        content(resp);

        cookie(resp);

        redirect(resp);

        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        
        PrintWriter writer = resp.getWriter();
        writer.print("안녕하세요");
    }

    private void content(HttpServletResponse resp) {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
//        생략 시 자동 생성
//        resp.setContentLength(2);
    }
    private void cookie(HttpServletResponse resp){
//        resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600;");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
        //resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    }

    private void redirect(HttpServletResponse resp) throws IOException{
        //Status Code 302
        //Location : /basic/hello-from.html

//        resp.setStatus(HttpServletResponse.SC_FOUND); //302
//        resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");

    }
}
