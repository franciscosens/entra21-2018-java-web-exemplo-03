package br.com.entra21java;

import javax.servlet.http.HttpServletRequest;

public class MyUtils {

    public String retornarURL(HttpServletRequest request) {
        String valor = request.getAttribute("javax.servlet.forward.request_uri").toString();
        return valor.replace("/null", "");
    }
}
