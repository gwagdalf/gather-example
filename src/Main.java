import static gatherer.distinctby.distinctBy;
import static gatherer.doubler.doubler;//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {

  // windowFixed
  List<List<Integer>> windows = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
      .gather(Gatherers.windowFixed(3))
      .toList();

  System.out.println("windowFixed(3) : " + windows);

  // windowSliding
  List<List<Integer>> slidingWindows = Stream.of(1, 2, 3, 4, 5)
      .gather(Gatherers.windowSliding(3))
      .toList();

  System.out.println("windowSliding(3) : " + slidingWindows);


  // Gatherers.scan(() -> 0, Integer::sum)
  List<Integer> cumulativeSum = Stream.of(1, 2, 3, 4, 5, 6)
      .gather(Gatherers.scan(() -> 0, Integer::sum))
      .toList();

  System.out.println("Gatherers.scan(() -> 0, Integer::sum) : " + cumulativeSum);
  // 결과: [1, 3, 6, 10, 15, 21]

  // doubler
  List<Integer> doublerList =
      Stream.of(1, 2, 3)
          .gather(doubler)
          .toList();

  System.out.println("doubler : " + doublerList);

  // distinctBy
  var distinctList = Stream.of("foo", "bar", "baz", "quux")
      .gather(distinctBy(String::length))
      .toList();

  System.out.println("distinctBy : " + distinctList);

  // distinctBy 2, uniqueByAge
  List<User> users = List.of(
      new User("1", "Alice", 25),
      new User("2", "Bob", 30),
      new User("3", "Charlie", 25),
      new User("4", "Diana", 35)
  );

  List<User> uniqueByAge = users.stream()
      .gather(distinctBy(User::age))
      .toList();

  System.out.println("uniqueByAge : " + uniqueByAge);

}
    record User(String id, String name, int age) {}
