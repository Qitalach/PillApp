package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CharlesPK3 on 4/3/15.
 */
public class PillBox {
    private static Map<String, Pill> pills = new HashMap<String, Pill>();

    public Map<String, Pill> getPills() {
        return Collections.unmodifiableMap(pills);
    }

    public void addPill(String pillName, Pill pill) {
        pills.put(pillName, pill);
    }

}
