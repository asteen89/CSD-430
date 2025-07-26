// File: DogTags.java Alisa Steensen Mod 10 Example
package module10example;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DogTags extends SimpleTagSupport {
    public void doTag() throws JspException,IOException
    {
        JspWriter out=getJspContext().getOut();
        out.println("Dogs are awesome!<br>");
    }
}
