package lk.rumex.Usermanagement.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CommonComponents {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
