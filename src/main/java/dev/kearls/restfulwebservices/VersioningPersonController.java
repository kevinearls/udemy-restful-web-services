package dev.kearls.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Fred Flinstone");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        Name name = new Name("Barney", "RUBBLE");
        return new PersonV2(name);
    }
}
