/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Processed data entity that extends from Data.
 */

package entities;

public class ProcessedData extends Data
{
  private String p_text;
  
  public ProcessedData(int id, String text, String date, String keyword, int final_label, String p_text)
  {
    super(id, text, date, keyword, final_label);
    
    this.p_text = p_text;
  }
  
  public void SetPText(String p_text)
  {
    this.p_text = p_text;
  }
  
  public String GetPText()
  {
    return(this.p_text);
  }
}
























