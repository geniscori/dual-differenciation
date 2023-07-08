# Dual differentiation

This was an assigment to take into practice the composite and visitor design patterns in Java.

Arithmetic expressions, those involving constants and the binary operators +,
−, ×, /, like 3 × (2 + 1), can be represented by a binary tree where constants are
leaves and nodes with two children the operators, being the left and right operands
the left and right subtrees. This is true if we exclude unary sign operators −4 and
+4 and consider only binary operators. F

We've defined different expressions that output the result of their application and their derivative as each class has its function and derivative function defined. This class is called *DualNumber*. With that, we can evaluate large expressions using composite method.

**Expressions defined:**
- `Expression` expression (public interface).
- `X` single float number.
- `BinaryOperator` abstract class with left and right sides for expressions.
- `DualNumber` number and its derivative.

**Operations defined:**
- `Addition`
- `Subtraction`
- `Constant`
- `Cos`
- `Sin`
- `Tan`
- `Log`
- `Power`

### How to use the code
Clone the repository to your local repository.

Inside the `src` folder go to `main` class and define the expression desired there. An example is provided with its implementation and validation using the Math library.