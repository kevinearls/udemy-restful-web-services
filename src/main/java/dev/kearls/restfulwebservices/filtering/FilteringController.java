package dev.kearls.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("filtering-list")
    public List<SomeBean> filteringList() {
        var bean1 = new SomeBean("Value1", "Value2", "Value3");
        var bean2 = new SomeBean("Value4", "Value5", "Value6");

        return List.of(bean1, bean2);
    }

}
