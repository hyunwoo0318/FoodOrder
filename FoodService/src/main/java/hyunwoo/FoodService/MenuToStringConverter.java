package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.Menu;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MenuToStringConverter implements Converter<Menu, String> {
    @Override
    public String convert(Menu source) {
        String menuName = source.getMenuName();
        int price = source.getPrice();
        String s = Integer.toString(price);
        return menuName + " , " + s;
    }
}
