# ex00 — Digit utilities

This exercise demonstrates a small `Digit` helper and a `Program` that computes the sum of digits for an integer.

Files
- `Program.java` — contains `Digit` and `Program` classes.

Purpose
- Show basic class design, string/character digit extraction, and handling of command-line arguments.

How it works (summary)
- `Digit` stores an `int` value and exposes methods:
	- `getDigit(int index)` — returns the digit at the given index where index 0 is the most-significant digit (leftmost). Throws `IndexOutOfBoundsException` for invalid indices.
	- `numberOfDigits()` — returns the number of digits in the absolute value of the stored number.
	- `SumOfDigits()` — computes the sum of all digits by calling `getDigit` repeatedly.
	- `toString()` — returns the decimal representation of the number.
- `Program.main` reads an optional command-line integer; if present and valid, it uses that number, otherwise it uses a hard-coded default. It prints the number and the sum of its digits.

Examples

Compile and run with default value:
```bash
javac Program.java
java Program
```

Run with a specific number:
```bash
java Program 67890
```

Expected output (for `67890`):
```
Number: 67890
Sum of digits: 30
```

Details & method explanations
- `getDigit(int index)` — converts `Math.abs(number)` to a `String`, checks bounds, and returns the numeric value of the character at `index` using `Character.getNumericValue`.
- `numberOfDigits()` — returns the length of the decimal string representation of the absolute value (so negative sign is ignored for digit counting).
- `SumOfDigits()` — iterates from index `0` to `numberOfDigits()-1` and sums `getDigit(i)`.

Edge cases & notes
- Negative numbers: digits are extracted from the absolute value; the sign is ignored for digit extraction.
- Zero: `numberOfDigits()` returns `1` and `SumOfDigits()` returns `0`.
- Large values: `Integer.parseInt` in `main` throws `NumberFormatException` for values outside `int` range — catch this or use `Long`/`BigInteger` if needed.

Possible improvements
- Add a method to index digits from the right (least-significant digit).
- Provide a method that returns all digits as an `int[]` or `List<Integer>` to avoid repeated string indexing.
- Add unit tests (JUnit) for `Digit` behavior (negative numbers, zero, single-digit numbers, large numbers).

Run & debug tips
- Compile with debug information: `javac -g Program.java`.
- Use print statements to inspect intermediate values or run in an IDE for step-through debugging.

If you want, I can add JUnit tests for `Digit` and a small harness to exercise edge cases.
