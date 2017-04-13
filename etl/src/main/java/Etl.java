import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

public class Etl {
    public ConcurrentMap<String, Integer> transform(Map<Integer, List<String>> old) {
        return        
            old
                .entrySet()
                .parallelStream()
                .collect(ConcurrentHashMap::new,
                    (c, e) -> e.getValue().forEach(letter -> c.put(letter.toLowerCase(), e.getKey())),
                    ConcurrentHashMap::putAll);
    }
}
