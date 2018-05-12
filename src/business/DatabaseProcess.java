/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Database processing other workflows of business layer.
 */

package business;

/*---------- Our Classes ---------*/
import entities.Data;
import entities.ProcessedData;
import data_access.DatabaseAccess;
/*--------------------------------*/

import java.util.ArrayList;

public class DatabaseProcess
{
  private String username, password, readdb, writedb;
  private Preprocess preprocess;
  private int[] tokens;
  private Boolean withlangid, encodechar;
  private char ml_or_lx;
  
  public DatabaseProcess(String username, String password, String readdb, String writedb, Preprocess preprocess, int[] tokens, Boolean withlangid, Boolean encodechar, char ml_or_lx) throws Exception
  {
    try
    {
      this.username = username;
      this.password = password;
      this.readdb = readdb;
      this.writedb = writedb;
      this.preprocess = preprocess;
      this.tokens = tokens;
      this.withlangid = withlangid;
      this.encodechar = encodechar;
      this.ml_or_lx = ml_or_lx;
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
  
  public void StartProcess() throws Exception
  {
    try
    {
      DatabaseAccess dbaccess = new DatabaseAccess(this.username, this.password, this.readdb, this.writedb);
      ArrayList<Data> data = dbaccess.ReadData();
      ArrayList<ProcessedData> pdata = new ArrayList<ProcessedData>();
      
      for(int i = 0; i < data.size(); i++)
      { 
        if(this.withlangid)
          pdata.add(new ProcessedData(data.get(i).GetID(), data.get(i).GetText(), data.get(i).GetDate(), data.get(i).GetKeyword(), data.get(i).GetFinalLabel(),
                                      this.preprocess.OutputWithLangID(data.get(i).GetText(), this.tokens, this.encodechar, this.ml_or_lx)));
        else
          pdata.add(new ProcessedData(data.get(i).GetID(), data.get(i).GetText(), data.get(i).GetDate(), data.get(i).GetKeyword(), data.get(i).GetFinalLabel(),
                                      this.preprocess.OutputWithoutLangID(data.get(i).GetText(), this.tokens, this.encodechar, this.ml_or_lx)));
      }
      
      dbaccess.WriteProcessedData(pdata);
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
}
























