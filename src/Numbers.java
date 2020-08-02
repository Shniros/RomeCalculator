import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Numbers {
    private Properties romeProperties;
    private Properties ansProperties;
    private Map<String,Integer> arabicMap;
    public Numbers(boolean haveRomeNumbers) throws IOException {
        romeProperties = new Properties();
        ansProperties = new Properties();
        arabicMap = new HashMap<>();
        if(haveRomeNumbers){
            loadRomeProperties();
        }else{
            loadArabicNumbers(10);
        }
    }
    public Object getNumber(String number) throws Exception {
        if(arabicMap.containsKey(number)){
            return arabicMap.get(number);
        }
        else if(romeProperties.containsKey(number)){
            return romeProperties.get(number);
        }
        else{
            throw new Exception("Error type number:"+number);
        }
    }
    public void loadRomeProperties() throws IOException {
        // FileInputStream in = new FileInputStream("classpath:prop/properties");
        FileInputStream rpInput = new FileInputStream("rome.properties");
        FileInputStream apInput  = new FileInputStream("ans.properties");
        ansProperties.load(apInput);
        romeProperties.load(rpInput);
    }
    public String ConvertToRome(String number){
        return String.valueOf(ansProperties.get(number));
    }
    public String numberToString(Object number){
        String temp = String.valueOf(number);
        if(ansProperties.containsKey(temp)){
            return ConvertToRome(temp);
        }
        else{
            return temp;
        }
    }
    private void loadArabicNumbers(int size){
        for(int i = 0; i <= size;i++){
            arabicMap.put(String.valueOf(i),i);
        }
    }
}
