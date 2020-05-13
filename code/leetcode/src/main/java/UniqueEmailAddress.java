import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
        System.out.println(uniqueEmailAddress.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniquemalis = new HashSet();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean skipDot = true;
            for (int i = 0; i < email.length();) {
                if (email.charAt(i) == '.') {
                    //continue
                    if (!skipDot) {
                        sb.append(email.charAt(i));
                    }
                    i++;
                } else {
                    if (email.charAt(i) == '+') {
                        while (i < email.length() && email.charAt(i) != '@') {
                            i++;
                        }
                        skipDot = false;
                    } else {
                        sb.append(email.charAt(i));
                        i++;
                    }
                }
            }
            uniquemalis.add(sb.toString());
        }
        return uniquemalis.size();
    }
}
