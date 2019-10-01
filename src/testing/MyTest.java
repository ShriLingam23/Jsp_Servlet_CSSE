package testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MyTest {

	@Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;

	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
 
	@Test
    public void testFullName() throws IOException, ServletException {
 
        when(request.getParameter("fn")).thenReturn("Vinod");
        when(request.getParameter("ln")).thenReturn("Kashyap");
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        MyServlet myServlet =new MyServlet();
        myServlet.doGet(request, response);
        String result = sw.getBuffer().toString().trim();
        assertEquals(result, new String("Full Name: Vinod Kashyap"));
 
    }

}
