package app.service;

import org.springframework.beans.factory.annotation.Autowired;

public class MultService {
    //ma mieć dostęp do SmallService

    @Autowired
    SmallService ss;

    //ma policzyć a*a - b*b; (a+b)*(a-b)
    public int squareDiff(int a, int b) {
        return ss.addNumbers(a,b) * ss.addNumbers(a,-b);
    }
}
