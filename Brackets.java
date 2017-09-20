import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Brackets {
    public static String parsing(String str) {
        int flagRoundBrackets = 0;
        int flagFigureBrakets = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            String s = str.substring(i, i + 1);
            if (s.equals("(")&&flagRoundBrackets>=0){
                stringBuilder.append(s);
                flagRoundBrackets++;
                continue;
            }
            if (s.equals("{")&&flagFigureBrakets>=0 ) {
                stringBuilder.append(s);
                flagFigureBrakets++;
                continue;
            }
            if (s.equals(")")&&flagRoundBrackets>=0){
                flagRoundBrackets--;

            }
            else {
                stringBuilder.append(s);
            }
            if (s.equals("}")&&flagFigureBrakets>=0){
                flagFigureBrakets--;
            } else {
                stringBuilder.append(s);
            }
        }
        if (flagRoundBrackets == 0 && flagFigureBrakets == 0) {
            return stringBuilder+" "+"correct";
        } else {
            return stringBuilder+" "+"uncorrect";
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println("Введите адрес файла ");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(new File(new Scanner(System.in).next()))));
        String f;
        int count=0;
        StringBuffer strBuffer = new StringBuffer();
        Map<String ,Integer> map = new HashMap<String,Integer>();
        while ((f=bufferedReader.readLine())!=null){
            StringTokenizer tokenizer = new StringTokenizer(f, " \t\n\r,:-.");
            while(tokenizer.hasMoreTokens()) {
                String s = tokenizer.nextToken();
                strBuffer.append(s);
                int cnt = map.get(s)!=null?map.get(s):0;
                cnt++;
                map.put(s, cnt);
            }
        }


        System.out.println(parsing(String.valueOf(strBuffer)));
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }




    }

}
