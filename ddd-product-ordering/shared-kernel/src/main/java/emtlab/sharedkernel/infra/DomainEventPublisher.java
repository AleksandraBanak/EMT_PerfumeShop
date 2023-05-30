package emtlab.sharedkernel.infra;

import emtlab.sharedkernel.domain.base.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

