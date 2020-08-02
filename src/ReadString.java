
import java.util.*;


public class ReadString {

        private String operKEY = "+*-/";
        private String KEY = "0123456789IVX";
        private boolean romeNumbersFlag = false;
        private String romeNumbersKey = "IVX";
        private Queue<String> qOperation = new LinkedList<>();
        private Queue<String> qNumbers  = new LinkedList<>();

        private Numbers iNumbers;

        public ReadString(String arline) throws Exception {
            String curNumber = "";
            for(char c:arline.toCharArray())
            {
                if(KEY.contains(String.valueOf(c))){
                    if(romeNumbersKey.contains(String.valueOf(c)))
                        romeNumbersFlag = true;
                    curNumber += String.valueOf(c);
                }else if(operKEY.contains(String.valueOf(c))){
                    qOperation.add(String.valueOf(c));
                    qNumbers.add(curNumber);
                    curNumber = "";
                }
            }
            qNumbers.add(curNumber);
            iNumbers = new Numbers(romeNumbersFlag);
        }
        public int nextNumber() throws Exception {
            return Integer.parseInt(
                    String.valueOf(iNumbers.getNumber(qNumbers.poll())));
        }
        public boolean isRomeNumbers(){
            return romeNumbersFlag;
        }
        public String nextOperation(){
            return qOperation.poll();
        }
}

