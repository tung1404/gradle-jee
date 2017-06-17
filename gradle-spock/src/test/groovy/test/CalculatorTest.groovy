package test

import spock.lang.Specification
import static test.Calculator.take

class CalculatorTest extends Specification {

	def "should calculate: #x + #y = #sum"() {

		expect:
			take(x).add(y).calculate() == sum

		where:
		x | y  | sum
		1 | 2  | 3
		2 | 5  | 7
		3 | -1 | 2
	}
}
