package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Lucas";
        } else {
            if(query.contains("plus")) {
                String firstOpStr = query.substring(8);
                String secondOpStr = firstOpStr.substring(firstOpStr.indexOf("plus "));
                firstOpStr = firstOpStr.substring(0, firstOpStr.indexOf(" "));
                secondOpStr = secondOpStr.substring(5);

                int one = Integer.parseInt(firstOpStr);
                int two = Integer.parseInt(secondOpStr);

                Integer result = one + two;

                return result.toString();
            }
            return "";
        }
    }
}
