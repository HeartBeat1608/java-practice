package codes;

import java.util.HashMap;

public class DecimalToRoman {
    private static final HashMap<Integer, String> _mapping = new HashMap<>();
    private static final int[] _order = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    DecimalToRoman() {
        if(_mapping.isEmpty()) {
            _mapping.put(1000, "M");
            _mapping.put(900, "CM");
            _mapping.put(500, "D");
            _mapping.put(400, "CD");
            _mapping.put(100, "C");
            _mapping.put(90, "XC");
            _mapping.put(50, "L");
            _mapping.put(40, "XL");
            _mapping.put(10, "X");
            _mapping.put(9, "IX");
            _mapping.put(5, "V");
            _mapping.put(4, "IV");
            _mapping.put(1, "I");
        }
    }

    public String toRoman(int num) {
        StringBuilder res = new StringBuilder();
        for(int p: _order) {
            // break early if we are done working
            if(num == 0) break;

            int q = Math.floorDiv(num, p);
            num = num % p;
            // work for this quotient
            while(q > 0) {
                res.append(_mapping.get(p));
                q--;
            }
        }
        return res.toString();
    }
}
