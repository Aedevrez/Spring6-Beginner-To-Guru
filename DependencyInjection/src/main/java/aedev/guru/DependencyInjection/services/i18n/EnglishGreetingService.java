package aedev.guru.DependencyInjection.services.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import aedev.guru.DependencyInjection.services.IMockService;

@Profile({"EN","default"})
@Service("i18N")
public class EnglishGreetingService implements IMockService{

    @Override
    public String sayGreeting() {
        return "Hello World!";
    }
    
}
