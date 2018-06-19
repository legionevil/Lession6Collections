import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by legionevil on 19.06.2018.
 */
public class Base {
    public static void main(String[] args) throws FileNotFoundException {
        //текст в файле - test do avoid rusty closed doors behind electric fence test test test fence
        File file = new File("D:\\example.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\*");
        System.out.println("Содержимое файла: " + sc.next());
        sc.close();

        //тут я абсолютно не понял как задать сканеру position=0, вызвал заново
        Scanner sc2 = new Scanner(file);
        SortedMap<String, Integer> statistics = new TreeMap<>();
        while (sc2.hasNext()){
            String word = sc2.useDelimiter("\\s+").next();
            Integer cnt = statistics.get(word);
            if (cnt == null){
                cnt = 0;
            }
            statistics.put(word, ++cnt);
       }
        System.out.println("Сортировка по алфавиту: " + statistics.keySet());
        System.out.println("Статистика: " + statistics);
        String maxKey = Collections.max(statistics.entrySet(), Map.Entry.comparingByValue()).getKey();
        int maxValue = Collections.max(statistics.entrySet(), Map.Entry.comparingByValue()).getValue();
        System.out.println("Максимум повторений у слова - " + maxKey + ", количество повторений - " + maxValue);
        sc2.close();
    }
}
