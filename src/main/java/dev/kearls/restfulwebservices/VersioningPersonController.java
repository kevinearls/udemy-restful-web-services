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

    // Versioning by request parameter http://localhost:8080/person?version=1
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonByParameter() {
        return new PersonV1("Fred Flinstone I");
    }

    // Versioning by request header X-API-VERSION=2
    // curl -H"X-API-VERSION: 2" http://localhost:8080/person | jq
    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonByHeader() {
        Name name = new Name("Betty", "RUBBLE");
        return new PersonV2(name);
    }

    // Versioning by setting the accept header
    //
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        Name name = new Name("Mr.", "SLATE");
        return new PersonV2(name);
    }


}
