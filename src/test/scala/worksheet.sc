val x = 1 + 1

1 + x

// Transform each number from 1 to 10 by multiplying each by 2,
// where the _ is a placeholder for the current element being "mapped" e.g. 10 * 2
(1 to 10) map { _ * 2 }

// Add all the numbers from 1 to 10 by reducing (to a single value),
// where the two _ are placeholders for two arguments being added e.g. 1 + 2
(1 to 10) reduce { _ + _ }

(1 to 10) sum

// Filter a list of numbers into two categories based on a criteria using partition.
// This example creates two lists of students based on their test scores, where a pass is 60 and above
val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition { _ >= 60 }