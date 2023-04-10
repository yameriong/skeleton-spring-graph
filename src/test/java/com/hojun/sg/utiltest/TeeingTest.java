package com.hojun.sg.utiltest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
https://www.netjstech.com/2022/01/java-stream-collectorsteeing-examples.html
        Java 17 teeing 이라는  stream API가 추가되었습니다.
        두 개의 stream을 소모하여, 두 개의 원하는 값을 뽑아내거나, 하나로 만들어 낼 수도 있습니다.
        잘만 사용하면 실제로 사용가능할 수 있을 것 같습니다.
        아래는 테스트 코드이니 참고하시면 될 것 같습니다.
        (teeing의 merger를 List로 할 경우 Optional 로 자동 생성 됨)
 */
@Slf4j
public class TeeingTest {
    @Test
    void beforeTeeingTest_1() {
        var count = Stream.of(1, 2, 3, 4, 5)
                .mapToLong(i -> i)
                .count();

        var sum = Stream.of(1, 2, 3, 4, 5)
                .mapToLong(i -> i)
                .sum();

        System.out.println(new Result(count, sum));
    }

    @Test
    void teeingTest_1() {
        var result = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.summingLong(n -> n),
                        Result::new));
        Assertions.assertEquals(5, result.count);
        Assertions.assertEquals(15, result.sum);
    }

    @Test
    void beforeTeeingTest_2() {
        var list = List.of(new Product(1, 1.0),
                new Product(2, 1.1),
                new Product(3, 2.0),
                new Product(4, 1.11));
        var max = list.stream().max(Comparator.comparing(Product::reviewScore)).orElseGet(Product::emptyOf);
        var min = list.stream().min(Comparator.comparing(Product::reviewScore)).orElseGet(Product::emptyOf);
        Assertions.assertEquals(3, max.productNo);
        Assertions.assertEquals(1, min.productNo);
    }

    @Test
    void teeingTest_2() {
        var result = Stream.of(new Product(1, 1.0),
                        new Product(2, 1.1),
                        new Product(3, 2.0),
                        new Product(4, 1.11))
                .collect(
                        Collectors.teeing(
                                Collectors.maxBy(Comparator.comparing(Product::reviewScore)),
                                Collectors.minBy(Comparator.comparing(Product::reviewScore)),
                                List::of));
        var maxReviewNo = result.get(0).orElseGet(Product::emptyOf).productNo;
        Assertions.assertEquals(3, maxReviewNo);
        var minReviewNo = result.get(1).orElseGet(Product::emptyOf).productNo;
        Assertions.assertEquals(1, minReviewNo);
    }

    record Result(
            Long count,
            Long sum
    ) {
    }

    record Product(
            long productNo,
            double reviewScore
    ) {
        public static Product emptyOf() {
            return new Product(0, 0);
        }
    }
}
