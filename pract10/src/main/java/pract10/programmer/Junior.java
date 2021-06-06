package pract10.programmer;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is coding");
    }
}
