package dev.kearls.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        var someBean = new SomeBean("value1", "value2", "value3");
        var mappingJacksonValue = new MappingJacksonValue(someBean);
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("filtering-list")
    public List<SomeBean> filteringList() {
        var bean1 = new SomeBean("Value1", "Value2", "Value3");
        var bean2 = new SomeBean("Value4", "Value5", "Value6");

        return List.of(bean1, bean2);
    }

}
