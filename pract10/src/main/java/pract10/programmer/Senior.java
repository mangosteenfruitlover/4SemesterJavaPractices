package pract10.programmer;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding");
    }
}
