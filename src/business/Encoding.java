/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Unicode encoding, decoding, replacements and other workflows of business layer.
 */

package business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoding
{ 
  public static String EncodeTRChar(String original, Boolean rm_emoji) throws Exception
  {
    String result = "";
    original = original.replace("\\n", "");
    
    try
    {
      char[] charr = original.toCharArray();
      
      Matcher m = Pattern.compile("(?i)\\\\u([\\da-f]{4})").matcher(original);
      
      Queue<Integer> tr_start = new LinkedList<Integer>();
      Queue<String> tr_uni = new LinkedList<String>();
      ArrayList<String> emo_uni = new ArrayList<String>();
      
      while(m.find())
      {
        if(m.group(1).charAt(0) != 'd')
        {
          tr_start.add(m.start());
          tr_uni.add(m.group(1));
        }
        else
          emo_uni.add(m.group(0));
      }
      
      for(int i = 0; i < charr.length; i++)
      {
        if(tr_start.contains(i))
        {
          result += (char)Integer.parseInt(tr_uni.remove(), 16);
          tr_start.remove();
          i += 5;
        }
        else if(i < charr.length - 3 && charr[i] == '\\' && charr[i + 2] != 'd')
          continue;
        else if(i < charr.length - 3 && charr[i] == '\\' && charr[i + 2] == 'd')
          result += "\\" + charr[i];
        else if((i == charr.length - 3 || i == charr.length - 2) && charr[i] == '\\')
          continue;
        else
          result += charr[i];
      }
      
      if(rm_emoji)
      {
        for(int i = 0; i < emo_uni.size(); i++)
          result = result.replace("\\" + emo_uni.get(i), "");
      }
      
      result = result.replaceAll("https://", " www.");
      result = result.replaceAll("http://", " www.");
      result = result.replaceAll("Http'm://", " www.");
      result = result.replaceAll("Http://", " www.");
    }
    catch(Exception ex)
    {
      throw(ex);
    }
    
    return(result);
  }
  
  public static String FixURLs(String original) throws Exception
  {
    String result = "";
    original = original.replace("\\n", "");
    
    try
    {
      char[] charr = original.toCharArray();
      
      for(int i = 0; i < charr.length; i++)
      {
        if(charr[i] == '\\')
          continue;
        else
          result += charr[i];
        
        result = result.replaceAll("https://", " www.");
        result = result.replaceAll("http://", " www.");
        result = result.replaceAll("Http'm://", " www.");
        result = result.replaceAll("Http://", " www.");
      }
    }
    catch(Exception ex)
    {
      throw(ex);
    }
    
    return(result);
  }
}






















