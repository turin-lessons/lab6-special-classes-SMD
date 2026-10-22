# Laboratory 6 — Special Classes in Kotlin

**Course:** Software Mobile Development  
**Student:** Akbarshoh Boymirzayev  
**Student ID:** se16017

## Overview

This project contains 15 Kotlin console exercises covering enum classes, sealed classes, and sealed interfaces.

The exercises demonstrate how to represent a closed set of values or types, handle different cases with exhaustive `when` expressions, and organize related classes.

Each task has its own package and `main()` function and can be run independently.

## Technologies

- Kotlin 2.2 or newer
- Kotlin/JVM
- JDK 17
- Gradle
- IntelliJ IDEA

Kotlin 2.2 or newer is required for the guard conditions used in Task 13.

All programs use `readln()` for input and `println()` for output. No graphical interface or Kotlin Multiplatform configuration is required.

## Tasks

| Task | Program | Main concepts |
|------|---------|---------------|
| 01 | Order status tracker | Enum constants, `entries`, `ordinal`, `valueOf()`, safe parsing, and reference equality |
| 02 | Calculator | Enum properties, abstract methods, companion objects, modulo, and exponentiation |
| 03 | Delivery cost calculator | Exhaustive `when` expressions and the additional `DRONE` delivery type |
| 04 | Payment processing | Sealed classes, data classes, and a singleton cash payment |
| 05 | Extended payment processing | Adding `Crypto` and updating all affected branches |
| 06 | Weather display | Loading, success, error, and offline states |
| 07 | Login and logout simulation | Sealed request and response types, session state, and refresh requests |
| 08 | Registration validation | Sealed constructors, validation errors, and minimum-age validation |
| 09 | Incident log | Severity enums, sorting, instance comparison, and critical alerts |
| 10 | Media player | An enum implementing a sealed interface and commands carrying data |
| 11 | Home devices | Multiple sealed interfaces, charging information, and waterproof devices |
| 12 | Error reporter | Inheritance restrictions, separate files, and indirect subclasses |
| 13 | Bus fare calculator | Guard conditions and age-dependent fares |
| 14 | Typed input parsing | Generics, covariance, `Nothing`, and early returns |
| 15 | Support desk | Enum priorities, sealed actions, comments, closing, and reopening tickets |

## Packages and Files

Tasks use packages from:

```kotlin
package org.example.task01
```

through:

```kotlin
package org.example.task15
```

Each task contains a `Main.kt` file.

Task 12 uses several files to demonstrate inheritance across files and packages:

| File | Package | Purpose |
|------|---------|---------|
| `Errors.kt` | `org.example.task12` | Declares the error hierarchy |
| `DiskFull.kt` | `org.example.task12` | Extends `IoError` from another file |
| `Main.kt` | `org.example.task12` | Reads commands and reports errors |
| `Overheated.kt` | `org.example.task12.other` | Extends the open `CustomError` class |

Task 05 contains its own extended payment implementation and runs independently of Task 04.

## Running the Programs

1. Open the project in IntelliJ IDEA.
2. Configure JDK 17 as the project SDK.
3. Allow Gradle synchronization to finish.
4. Open the desired task's `Main.kt`.
5. Click the green Run button next to `fun main()`.
6. Enter the requested input in the Run console.

Press **Enter** after each input line.

For programs that keep reading commands, use the following commands to finish:

| Tasks | Exit command |
|-------|--------------|
| 06, 07, 15 | `exit` |
| 09, 12 | `end` |
| 10 | `quit` |
| 11 | `done` |

## Usage Examples

### Task 02 — Calculator

Input:

```text
2 ^ 10
```

Result:

```text
2.0 ^ 10.0 = 1024.0
```

Other supported operators:

```text
+  -  *  /  %  ^
```

### Task 06 — Weather

Enter these values on separate lines:

```text
Tashkent
Paris
offline
exit
```

The program demonstrates successful loading, a missing-city error, and the offline state.

### Task 13 — Bus Fare

For a base fare of 2,000 UZS:

| Passenger | Fare |
|-----------|------|
| Child younger than 4 | 0 UZS |
| Child aged 4–17 | 1,000 UZS |
| Adult aged 18–59 | 2,000 UZS |
| Senior aged 60–80 | 1,400 UZS |
| Senior older than 80 | 0 UZS |

### Task 15 — Support Desk

Example commands:

```text
open urgent Printer is broken
open high Internet connection problem
open normal Add new user
comment 1 Checked the cable
close 1
reopen 1
list
exit
```

Supported priorities:

```text
LOW, NORMAL, HIGH, URGENT
```

## Learning Outcomes

After completing these exercises, students should be able to:

- Use enums for fixed sets of named values.
- Model related cases with sealed classes and interfaces.
- Handle every case using exhaustive `when` expressions.
- Distinguish regular classes, data classes, and singleton objects.
- Apply sealed inheritance restrictions across files and packages.
- Combine several interfaces in one class.
- Represent typed success and failure results using generics.
- Use guard conditions and early returns to simplify conditional logic.

## Notes

- Weather information and login accounts are stored locally for demonstration.
- No external APIs or databases are required.
- The source contains the final working versions with the requested extensions.
- The laboratory's written questions and intentional compiler-error experiments are separate activities. Temporary changes that break compilation should be reverted before running the project.
