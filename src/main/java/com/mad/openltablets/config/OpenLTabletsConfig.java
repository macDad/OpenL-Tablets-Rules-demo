package com.mad.openltablets.config;

import com.mad.openltablets.model.Person;
import com.mad.openltablets.rules.IExampleRule;
import org.openl.rules.runtime.RulesEngineFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenLTabletsConfig {

  @Bean
  public RulesEngineFactory<IExampleRule> rulesEngineFactory() throws Exception {
    return new RulesEngineFactory<>(
        Person.class.getResource("rules/AgeDiscountRule.xls"), IExampleRule.class);
  }
}
