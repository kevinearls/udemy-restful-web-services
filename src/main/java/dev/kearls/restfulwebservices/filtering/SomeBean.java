package dev.kearls.restfulwebservices.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = { "field2" })
@JsonFilter("SomeBeanFilter")
public record SomeBean(String field1, String field2, String field3) {

}
