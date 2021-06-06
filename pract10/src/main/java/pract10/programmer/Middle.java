package pract10.programmer;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding");
    }
}
