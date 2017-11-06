package priv.rdo.sorting

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author WrRaThY
 * @since 06.11.2017
 */
class BubbleSortTest extends Specification {
    @Unroll
    def "sort should return #expectedResult for #input"() {
        expect:
            new BubbleSort<>().sort(input) == expectedResult

        where:
            input                                               || expectedResult
            []                                                  || []
            [1]                                                 || [1]
            [1, 2, 3]                                           || [1, 2, 3]
            [3, 1, 2, 3]                                        || [1, 2, 3, 3]
            [3, 1, 2, 18, 3]                                    || [1, 2, 3, 3, 18]
            [9, 7, 6, 15, 16, 5, 10, 11]                        || [5, 6, 7, 9, 10, 11, 15, 16]
            [5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4]                || [0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
            [User.user(1, 1)]                                   || [User.user(1, 1)]
            [User.user(1, 1), User.user(3, 1)]                  || [User.user(1, 1), User.user(3, 1)]
            [User.user(1, 1), User.user(3, 1), User.user(2, 1)] || [User.user(1, 1), User.user(2, 1), User.user(3, 1)]
            [User.user(1, 1), User.user(3, 3), User.user(3, 1)] || [User.user(1, 1), User.user(3, 1), User.user(3, 3)]
    }
}
