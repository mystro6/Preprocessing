/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Reading json objects other workflows of business layer.
 */

package business;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader
{
  public static String ReadAnObject(String jsonobject) throws Exception
  {
    String result = "";
    
    try
    {
      JSONParser parser = new JSONParser();
      JSONObject jobject = (JSONObject)parser.parse(jsonobject);
      
      result = jobject.get("text").toString();
    }
    catch(Exception ex)
    {
      throw(ex);
    }
    
    return(result);
  }
}
