package com.epam.jwt.task5.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FooterTag extends TagSupport {

    public int doStartTag() throws JspException {

        String str = "<footer class=\"container py-5\">\n" +
                "  <div class=\"row\">\n" +
                "    <div class=\"col-12 col-md\">\n" +
                "      <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"24\" height=\"24\" viewBox=\"0 0 24 24\" fill=\"none\" stroke=\"currentColor\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"d-block mb-2\" focusable=\"false\" role=\"img\"><title>Product</title><circle cx=\"12\" cy=\"12\" r=\"10\"></circle><line x1=\"14.31\" y1=\"8\" x2=\"20.05\" y2=\"17.94\"></line><line x1=\"9.69\" y1=\"8\" x2=\"21.17\" y2=\"8\"></line><line x1=\"7.38\" y1=\"12\" x2=\"13.12\" y2=\"2.06\"></line><line x1=\"9.69\" y1=\"16\" x2=\"3.95\" y2=\"6.06\"></line><line x1=\"14.31\" y1=\"16\" x2=\"2.83\" y2=\"16\"></line><line x1=\"16.62\" y1=\"12\" x2=\"10.88\" y2=\"21.94\"></line></svg>\n" +
                "      <small class=\"d-block mb-3 text-muted\">&copy; 2017-2018</small>\n" +
                "    </div>" +
                "</div>" +
                "</footer>";

        try {

            JspWriter out = pageContext.getOut();

            out.write(str);

        } catch (IOException e) {

            throw new JspException(e.getMessage());

        }

        return SKIP_BODY;
    }
}
