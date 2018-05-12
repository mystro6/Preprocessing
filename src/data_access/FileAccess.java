/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * File accessing of data access layer.
 */

package data_access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileAccess
{
  private String readpath, writepath;
  private BufferedReader bufferedreader;
  private BufferedWriter bufferedwriter;
  
  public FileAccess(String _readpath, String _writepath) throws Exception
  {
    try
    {
      this.readpath = _readpath;
      this.writepath = _writepath;
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
  
  public String ReadDataFromFile() throws Exception
  {
    String data = "";
    
    try
    {
      String reading = "";
      
      this.bufferedreader = new BufferedReader(
        new InputStreamReader(
          new  FileInputStream(this.readpath), "UTF8"
        )
      );
      
      while((reading = this.bufferedreader.readLine()) != null)
      {
        data += reading;
        data += "\n";
      }
      
      this.bufferedreader.close();
    }
    catch(Exception ex)
    {
      if(this.bufferedreader != null)
        this.bufferedreader.close();
        
      throw(ex);
    }
    
    return(data);
  }
  
  public void WriteDataToFile(String data) throws Exception
  {
    try
    {
      this.bufferedwriter = new BufferedWriter(new FileWriter(this.writepath));
      this.bufferedwriter.write(data);
      this.bufferedwriter.close();
    }
    catch(Exception ex)
    {
      if(this.bufferedwriter != null)
        this.bufferedwriter.close();
        
      throw(ex);
    }
  }
}






















