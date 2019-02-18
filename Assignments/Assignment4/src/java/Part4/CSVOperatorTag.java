/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part4;

import java.sql.*;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 *
 * @author kinyang
 */
public class CSVOperatorTag extends SimpleTagSupport {

    private static final String CSV_JDBC_DRIVER = "org.relique.jdbc.csv.CsvDriver";
    private static final String CSV_JDBC_HEADER = "jdbc:relique:csv:";
    
    private String filename;

    private String[] titles;
    private List<String[]> result;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            String path = "WEB-INF/files";
            try {
                Class.forName(CSV_JDBC_DRIVER);
                Connection connection = DriverManager.getConnection(CSV_JDBC_HEADER + path);
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery("select * from " + filename);
                ResultSetMetaData data = results.getMetaData();
                // get titles
                int columnCount = data.getColumnCount();
                titles = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    String title = data.getColumnName(i);
                    titles[i-1] = title;
                }
                // get results 
                result = new ArrayList<>();
                while (results.next()) {
                    String[] row = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        String value = results.getString(i);
                        row[i-1] = value;
                    }
                    result.add(row);
                }
                results.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            out.println("<h1 align=\"center\">" + filename + ".csv</h1>");
            out.println("<table border=1>");
            out.println("<tr/>");
            for (int i = 0; i < titles.length; i++) {
                out.println("<th/>" + titles[i]);
            }
            for (int i = 0; i < result.size(); i++) {
                out.println("<tr/>");
                for (int j = 0; j < result.get(i).length; j++) {
                    out.println("<td/>" + result.get(i)[j]);
                }
            }
            out.println("</table>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in CSVOperatorTag tag", ex);
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
