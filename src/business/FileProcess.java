/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * File processing and other workflows of business layer.
 */

package business;

/*---------- Our Classes ---------*/
import data_access.FileAccess;
/*--------------------------------*/

public class FileProcess
{
  private Preprocess preprocess;
  private FileAccess fileaccess;
  private int[] tokens;
  private String readpath, writepath;
  private Boolean withlangid, encodechar;
  private char ml_or_lx;
  
  public FileProcess(String _readpath, String _writepath, int[] _tokens, Preprocess _preprocess, Boolean _withlangid, Boolean _encodechar, char ml_or_lx) throws Exception
  {
    try
    {
      this.withlangid = _withlangid;
      this.encodechar = _encodechar;
      this.readpath = _readpath;
      this.writepath = _writepath;
      this.fileaccess = new FileAccess(this.readpath, this.writepath);
      this.preprocess = _preprocess;
      this.tokens = _tokens;
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
      String data = this.fileaccess.ReadDataFromFile();
      
      if(this.withlangid)
      {
        data = this.preprocess.OutputWithLangID(data, this.tokens, this.encodechar, this.ml_or_lx);
        this.fileaccess.WriteDataToFile(data);
      }
      else
      {
        data = this.preprocess.OutputWithoutLangID(data, this.tokens, this.encodechar, this.ml_or_lx);
        this.fileaccess.WriteDataToFile(data);
      }
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
}





























