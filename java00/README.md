# Java: Essentials for Today

This README collects the concise, practical Java knowledge you'll need for working on small exercises today (compiling, running, debugging, and common pitfalls).

**Quick Commands**

- Compile a single file:

```bash
javac ex00/Program.java
```

- Run a compiled class (class files in `ex00`):

```bash
java -cp ex00 Program 12345
```

- Compile whole project (recursively):

```bash
javac $(find . -name "*.java")
```

**Project layout & packages**

- Keep source files under folder structure that matches packages.
- If a file declares `package com.foo;`, run `java` from the project root and use `-cp` with the root directory (don't pass the `.java` path directly).

**Basic Java facts**

- Entry point: `public static void main(String[] args)`.
- Primitive types: `int`, `long`, `short`, `byte`, `char`, `boolean`, `float`, `double`.
- Wrapper classes: `Integer`, `Long`, `Character`, etc. (use `valueOf` instead of constructors).
- Strings are `java.lang.String` (immutable).

**Common compile/runtime issues**

- "cannot find symbol": usually a typo or missing import.
- "class not found" at runtime: wrong classpath or package mismatch.
- If you change package declarations, recompile and run from project root.

**The `Integer` wrapper (short)**

- Immutable wrapper for `int`. Extends `Number`, implements `Comparable<Integer>`.
- Useful static methods: `valueOf`, `parseInt`, `toString`, `compare`, bit utilities like `bitCount`, `numberOfLeadingZeros`.
- Constants: `Integer.MIN_VALUE`, `Integer.MAX_VALUE`, `Integer.SIZE`, `Integer.BYTES`.

**About the `Digit` / `Program` example**

- `Digit` stores an `int` and exposes `numberOfDigits()` and `getDigit(index)`.
- `getDigit(index)` in the rewritten example treats index 0 as the most-significant digit.
- To run the example in `ex00`:

```bash
javac ex00/Program.java
java -cp ex00 Program 67890
```

**Reading input**

- Use `Scanner` for simple stdin parsing:

```java
Scanner in = new Scanner(System.in);
int x = in.nextInt();
```

- Close `Scanner` only when finished; prefer `try (Scanner in = new Scanner(System.in)) { ... }`.

**Debugging tips**

- Add `-g` when compiling to include debug info (default in many setups): `javac -g MyClass.java`.
- Use an IDE (IntelliJ, VS Code with Java extension) for breakpoints and step-through.
- Print statements (`System.out.println`) are quick and portable.

**Style & safety**

- Prefer `final` for fields that shouldn't change.
- Avoid deprecated constructors like `new Integer(int)`: use `Integer.valueOf(int)`.
- Check for `NumberFormatException` when parsing user input.

**Tests**

- For small exercises, write a few `main` tests or use JUnit for automated tests.

**Resources**

- Java SE API docs: https://docs.oracle.com/en/java/
- Quick tutorial: https://docs.oracle.com/javase/tutorial/

---

If you want this README tailored to a specific focus (e.g., unit testing, command-line parsing, or fixing common compiler errors), tell me which and I'll extend it.