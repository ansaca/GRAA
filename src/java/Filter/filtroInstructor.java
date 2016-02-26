/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Instructor;


/**
 *
 * @author G40-80
 */
public class filtroInstructor implements Filter{

      private FilterConfig configuration;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      this.configuration = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
        String tipo=((HttpServletRequest) request).getSession().getAttribute("tipo").toString();
        if(tipo!=null)
        {
            if(!tipo.equals("Instructor"))
            {
                ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
            }else{
                Instructor instructorLogeado =(Instructor)((HttpServletRequest)request).getSession().getAttribute("Usuario");
                if(instructorLogeado!=null){
                    chain.doFilter(request, response);
                }else{
                    ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
                }
            
            }
        }
        }catch(NullPointerException e){
            ((HttpServletResponse)response).sendRedirect("faces/SesionInvalida.xhtml");
        }
    }

    @Override
    public void destroy() {
        this.configuration = null;
    }
    
}
