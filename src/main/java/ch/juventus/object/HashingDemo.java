package ch.juventus.object;

import java.util.HashMap;
import java.util.Map;

public class HashingDemo {

    public static void main(String[] args) {
        Map<DataKey, Integer> map = getAllData();

        DataKey key = new DataKey();
        key.setId(1);
        key.setName("Linda");
        System.out.println(key.hashCode());

        Integer value = map.get(key);

        System.out.println(value);

    }

    private static Map<DataKey, Integer> getAllData() {
        Map<DataKey, Integer> map = new HashMap<>();

        DataKey key = new DataKey();
        key.setId(1);
        key.setName("Linda");
        System.out.println(key.hashCode());

        map.put(key, 10);

        return map;
    }
}
