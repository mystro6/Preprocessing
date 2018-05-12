/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Database accessing of data access layer.
 */

package data_access;

/*---------- Our Classes ---------*/
import entities.ProcessedData;
import entities.Data;
/*--------------------------------*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseAccess
{
  private String username, password, readdb, writedb, connstring;
  private Connection conn;
  private Statement stmt;
  
  public DatabaseAccess(String username, String password, String readdb, String writedb) throws Exception
  {
    try
    {
      this.username = username;
      this.password = password;
      this.readdb = readdb;
      this.writedb = writedb;
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
  
  private int GetLastID() throws Exception
  {
    int id = -1;
    
    try
    {
      // 172.17.16.28
      this.connstring = "jdbc:mysql://localhost/" + this.writedb + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
      this.conn = DriverManager.getConnection(this.connstring, this.username, this.password);
      this.stmt = this.conn.createStatement();
      
      // select id from nlp order by id desc limit 1
      String query = "select id from processed order by id desc limit 1";
      
      ResultSet rset = this.stmt.executeQuery(query);
      
      while(rset.next())
      {
        id = rset.getInt("id");
      }

      this.conn.close();
      this.stmt.close();
    }
    catch(Exception ex)
    {
      if(this.conn != null)
        this.conn.close();
        
      if(this.stmt != null)
        this.stmt.close();
      
      throw(ex);
    }

    return(id);
  }
  
  public ArrayList<Data> ReadData() throws Exception
  {
    ArrayList<Data> rows = new ArrayList<Data>();
    
    try
    {
      // select id, keyword, final_label, tweet, creation_time from labeled_tweets where id > " + this.GetLastID() + " limit 100000
      String query = "select * from processed_updated where id > 499999 and keyword = 'product'";
      
      // 172.17.16.28
      this.connstring = "jdbc:mysql://localhost/" + this.readdb + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
      this.conn = DriverManager.getConnection(this.connstring, this.username, this.password);
      this.stmt = this.conn.createStatement();
      
      ResultSet rset = this.stmt.executeQuery(query);
      
      while(rset.next())
      {
        // Data jdata = new Data(rset.getInt("id"), rset.getString("tweet"), rset.getString("creation_time"), rset.getString("keyword"), rset.getInt("final_label"));
        Data jdata = new Data(rset.getInt("id"), rset.getString("p_text"), rset.getString("p_date"), rset.getString("keyword"), rset.getInt("final_label"));
        rows.add(jdata);
      }
      
      this.conn.close();
      this.stmt.close();
    }
    catch(Exception ex)
    {
      if(this.conn != null)
        this.conn.close();
        
      if(this.stmt != null)
        this.stmt.close();
      
      throw(ex);
    }
    
    return(rows);
  }
  
  public void WriteProcessedData(ArrayList<ProcessedData> pdata) throws Exception
  {
    try
    {
      // 172.17.16.28
      this.connstring = "jdbc:mysql://localhost/" + this.writedb + "?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
      this.conn = DriverManager.getConnection(this.connstring, this.username, this.password);
      this.stmt = this.conn.createStatement();
      
      String query = "";
      
      for(int i = 0; i < pdata.size(); i++)
      {
        //query = "insert into nlp values("
        //    + pdata.get(i).GetID() + ", '"
        //    + pdata.get(i).GetPText().replace("'", "\\'") + "', '"
        //    + pdata.get(i).GetKeyword().replace("'", "\\'") + "', "
        //    + pdata.get(i).GetFinalLabel() + ", '"
        //    + pdata.get(i).GetDate() + "')";
        query = "insert into processed values("
                + pdata.get(i).GetID() + ", '"
                + pdata.get(i).GetPText().replace("'", "") + "', '"
                + pdata.get(i).GetKeyword().replace("'", "") + "', "
                + pdata.get(i).GetFinalLabel() + ", '"
                + pdata.get(i).GetDate() + "')";
        
        this.stmt.execute(query);
      }
      
      this.conn.close();
      this.stmt.close();
    }
    catch(Exception ex)
    {
      if(this.conn != null)
        this.conn.close();
      
      if(this.stmt != null)
        this.stmt.close();
      
      throw(ex);
    }
  }
}




















