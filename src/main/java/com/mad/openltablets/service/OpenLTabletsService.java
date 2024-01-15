package com.mad.openltablets.service;

import com.mad.openltablets.model.Person;
import com.mad.openltablets.rules.IExampleRule;
import lombok.AllArgsConstructor;
import org.openl.rules.runtime.RulesEngineFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpenLTabletsService {

  private final RulesEngineFactory<IExampleRule> rulesEngineFactory;

  public Person applyDiscount(Person person) {
    rulesEngineFactory.newEngineInstance().applyRules(person);
    return person;
  }
}
