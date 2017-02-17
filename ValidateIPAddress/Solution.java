package ValidateIPAddress;

/**
 * Created by whong53 on 2/16/17.
 */
public class Solution {
    static final String IPV4 = "IPv4";
    static final String IPV6 = "IPv6";
    static final String NEITHER = "Neither";

    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
                return NEITHER;
            }
            String[] items = IP.split("\\.");
            if (items.length != 4) {
                return NEITHER;
            }
            for (String item : items) {
                if (item.length() == 0 || item.length() > 3) {
                    return NEITHER;
                }
                for (char c : item.toCharArray()) {
                    if (c < '0' || c > '9') {
                        return NEITHER;
                    }
                }
                int digit = Integer.valueOf(item);
                if (digit < 0 || digit > 255 || (digit != 0 || item.length() != 1) && item.charAt(0) == '0') {
                    return NEITHER;
                }
            }
            return IPV4;
        } else if (IP.contains(":")) {
            if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
                return NEITHER;
            }
            String[] items = IP.split("\\:");
            if (items.length != 8) {
                return NEITHER;
            }
            for (String item : items) {
                if (item.length() == 0 || item.length() > 4) {
                    return NEITHER;
                }
                item = item.toLowerCase();
                for (char c : item.toCharArray()) {
                    if (c < '0' || (c > '9' && c < 'a') || c > 'f') {
                        return NEITHER;
                    }
                }
            }
            return IPV6;
        } else {
            return NEITHER;
        }
    }
}
