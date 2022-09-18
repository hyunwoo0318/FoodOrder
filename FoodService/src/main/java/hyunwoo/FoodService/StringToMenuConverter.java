package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.Menu;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMenuConverter implements Converter<String, Menu> {
    @Override
    public Menu convert(String source) {
        String[] split = source.split(",", 2);
        Menu menu = new Menu();
        menu.setMenuName(split[0]);
        menu.setPrice(Integer.parseInt(split[1]));
        return menu;
    }
}
