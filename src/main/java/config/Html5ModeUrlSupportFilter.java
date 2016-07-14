package config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by alimohammadi on 7/6/16.
 */
@Component
public class Html5ModeUrlSupportFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isStatic(request) || isApi(request)) {
            filterChain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }

    private boolean isApi(HttpServletRequest request) {
        return request.getRequestURI().indexOf("/api/") >= 0;
    }

    private boolean isStatic(HttpServletRequest request) {
        return Pattern.matches(".+\\.((html)|(css)|(js))$", request.getRequestURI());
    }
}
