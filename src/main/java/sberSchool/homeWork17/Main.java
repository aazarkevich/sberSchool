package sberSchool.homeWork17;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("sberSchool.homeWork17")
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        File file = context.getBean(FileImpl.class);

        String[] paths = new String[]{"http://www.google.ru/intl/en_com/images/logo_plain.png",
                "https://e7.pngegg.com/pngimages/178/925/png-clipart-cartoon-graphy-the-little-boy-wanted-to-question-child-photography-thumbnail.png",
                "https://e7.pngegg.com/pngimages/152/1021/png-clipart-lion-cartoon-animation-lion-lion-mammal-animals-thumbnail.png"};
        file.download(paths);
    }
}
