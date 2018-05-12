/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Generic data entity.
 */

package entities;

public class Data
{
  private int id;
  private String text;
  private String date;
  private String keyword;
  private int final_label;
  
  public Data(int id, String text, String date, String keyword, int final_label)
  {
    this.id = id;
    this.text = text;
    this.date = date;
    this.keyword = keyword;
    this.final_label = final_label;
  }
  
  public void SetID(int id)
  {
    this.id = id;
  }
  
  public void SetText(String text)
  {
    this.text = text;
  }
  
  public void SetDate(String date)
  {
    this.date = date;
  }
  
  public void SetKeyword(String keyword)
  {
    this.keyword = keyword;
  }
  
  public void SetFinalLabel(int final_label)
  {
    this.final_label = final_label;
  }
  
  public int GetID()
  {
    return(this.id);
  }
  
  public String GetText()
  {
    return(this.text);
  }
  
  public String GetDate()
  {
    return(this.date);
  }
  
  public String GetKeyword()
  {
    return(this.keyword);
  }
  
  public int GetFinalLabel()
  {
    return(this.final_label);
  }
}


























