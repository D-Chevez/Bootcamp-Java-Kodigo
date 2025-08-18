package service.filter;

import model.Task;
import java.time.LocalDate;

public class DueDateRangeSpecification implements Specification<Task>{
    private final LocalDate from;
    private final LocalDate to;

    public DueDateRangeSpecification(LocalDate from, LocalDate to) {
        this.from = from; this.to = to;
    }

    @Override public boolean isSatisfiedBy(Task t) {
        var d = t.getDueDate();
        if (d == null) return false;
        if (from != null && d.isBefore(from)) return false;
        if (to != null && d.isAfter(to)) return false;
        return true;
    }
}
