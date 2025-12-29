package gatherer;

import static java.util.stream.Gatherer.ofSequential;

import java.util.stream.Gatherer;
import java.util.function.Function;

public class doubler {
  public static final Gatherer<Integer, Void, Integer> doubler =
      ofSequential(
          (state, element, downstream) -> downstream.push(element * 2)
      );

}
