package ohtu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 
@ComponentScan(basePackages = "ohtu.verkkokauppa")//määrää, että etsitään annotoituja luokkia pakkauksesta ohtu.verkkokauppa
public class AppConfig  {}
