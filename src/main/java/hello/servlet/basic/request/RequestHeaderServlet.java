package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("--- REQUEST-LINE - -end ---");
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " +  request.getHeader(headerName));
        }
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header convenience look up start ---");
        System.out.println("[Host convenience look up]");
        System.out.println("request.getServerName() = "+ request.getServerName()); //Host ??????
        System.out.println("request.getServerPort() = "+ request.getServerPort()); //Host ??????
        System.out.println();
        System.out.println("[Accept-Language convenience look up]");

        request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " +locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie convenience look up]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content convenience look up]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header convenience look up end ---");
        System.out.println();
    }

    //?????? information
    private void printEtc(HttpServletRequest request) {
     System.out.println("--- etc look up start ---");
     System.out.println("[Remote information]");
     System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
     System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
     System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
     System.out.println();
     System.out.println("[Local information]");
     System.out.println("request.getLocalName() = " + request.getLocalName()); //
     System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
     System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
     System.out.println("--- etc look up end ---");
     System.out.println();
    }
}
