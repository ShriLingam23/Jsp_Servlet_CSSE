package fileUpload;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.opencsv.CSVReader;


@WebServlet(name = "upload", urlPatterns = { "/upload" })
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieves <input type="text" name="description">
		String description = request.getParameter("description"); 
		
		// Retrieves <input type="file" name="file">
	    Part filePart = request.getPart("file"); 
	    
	    // MSIE fix.
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
	    
	    InputStream fileContent = filePart.getInputStream();
	    Reader in = new InputStreamReader(fileContent);
	    
	    CSVReader reader;
	    Iterator<String[]> iterator;
	    
	    try {
	    	
		    reader = new CSVReader(new InputStreamReader(fileContent));
	        iterator = reader.iterator();
	        
	        String[] row = iterator.next();

	        Map<Object, String> map = new HashMap<>();
	        for(int i = 0; i < row.length; i++){
	            map.put(i, row[i]);
	        }
	        
	        System.out.println(map); 
		    
	    }catch(Exception e) {
	    	
	    }
	    
	    in.close();
	    
	}

}
