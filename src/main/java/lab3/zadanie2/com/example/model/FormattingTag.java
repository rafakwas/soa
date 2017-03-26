package lab3.zadanie2.com.example.model;


import com.sun.tracing.dtrace.Attributes;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class FormattingTag extends BodyTagSupport {
    protected BodyContent bodyContent;

    private String header;
    private String color;
    private String adjust;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAdjust(String adjust) {
        this.adjust = adjust;
    }

    public int doStartTag()
    {
        return EVAL_BODY_BUFFERED;
    }
    public int doEndTag()
    {
        try
        {
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();
            if(str != null)
            {
                out.println("<h3>"+header+"</h3>");
                StringBuilder stringBuilder = new StringBuilder();
                if (adjust != null) {
                    stringBuilder.append(" align=" + adjust);
                }
                if (color != null) {
                    stringBuilder.append(" style=\"color:"+color+";\"");
                }
                out.println("<p"+ stringBuilder.toString() +">" + str + "</p>");
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return EVAL_PAGE;
    }
}
