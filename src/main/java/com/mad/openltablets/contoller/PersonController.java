package com.mad.openltablets.contoller;

import com.mad.openltablets.model.Person;
import com.mad.openltablets.service.OpenLTabletsService;
import com.mad.openltablets.util.LogUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

  private final OpenLTabletsService openLTabletsService;

  public PersonController(OpenLTabletsService openLTabletsService) {
    this.openLTabletsService = openLTabletsService;
  }

  @GetMapping("/checkDiscount/{name}/{age}")
  public Person applyDiscount(@PathVariable String name, @PathVariable int age) {
    LogUtils.INFO(this.getClass(), "applyDiscount", "Api call for checkDiscount name:%sage:%d".formatted(name, age));
    Person person = new Person(name, age);

    return openLTabletsService.applyDiscount(person);
  }
}
