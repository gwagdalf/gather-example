package gatherer;

import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Gatherer;

public class distinctby {
  public static <T, U> Gatherer<T, ?, T> distinctBy(Function<? super T, ? extends U> keyExtractor) {
    Objects.requireNonNull(keyExtractor, "keyExtractor must not be null");

    return Gatherer.ofSequential(
        () -> new HashSet<U>(),
        Gatherer.Integrator.ofGreedy((seen, element, downstream) -> {
          U key = keyExtractor.apply(element);
          if (seen.add(key)) {
            return downstream.push(element);
          }
          return true;
        })
    );
  }
}
