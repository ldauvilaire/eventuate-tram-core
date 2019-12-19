package io.eventuate.tram.events.micronaut.subscriber;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.micronaut.context.annotation.Context;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

@Context
public class DomainEventDispatcherInitializer {

  private DomainEventDispatcher[] domainEventDispatchers;

  public DomainEventDispatcherInitializer(DomainEventDispatcher[] domainEventDispatchers) {
    this.domainEventDispatchers = domainEventDispatchers;
  }

  @PostConstruct
  public void init() {
    Arrays.stream(domainEventDispatchers).forEach(DomainEventDispatcher::initialize);
  }
}