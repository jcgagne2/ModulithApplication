package ch.bdt.spike.spring.cloud.modulithapplication.core.web;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.EventPublication;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/core/events")
@RequiredArgsConstructor
public class EventController {

    private final CompletedEventPublications completedEventPublications;

    private final IncompleteEventPublications incompleteEventPublications;

    @GetMapping("/completed/all")
    public Collection<EventPublicationVO> getCompletedEvents() {
        return completedEventPublications.findAll().stream()
                .map(EventPublicationVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/completed/clear")
    public void clearCompletedEvents() {
        completedEventPublications.deletePublications((e) -> true);
    }

    @GetMapping("/incomplete/resubmit")
    public String getIncompleteEvents() {
        incompleteEventPublications.resubmitIncompletePublications((e) -> true);
        return "Events resubmitted";
    }

    @RequiredArgsConstructor
    public static class EventPublicationVO  {
        private final EventPublication delegate;

        public UUID getIdentifier() {
            return delegate.getIdentifier();
        }

        public boolean isCompleted() {
            return delegate.isCompleted();
        }

        public Instant getPublicationDate() {
            return delegate.getPublicationDate();
        }

        public int getCompletionAttempts() {
            return delegate.getCompletionAttempts();
        }

        public @Nullable Instant getLastResubmissionDate() {
            return delegate.getLastResubmissionDate();
        }

        public Optional<Instant> getCompletionDate() {
            return delegate.getCompletionDate();
        }

        public Object getEvent() {
            return delegate.getEvent();
        }

        public EventPublication.Status getStatus() {
            return delegate.getStatus();
        }
    }
}
