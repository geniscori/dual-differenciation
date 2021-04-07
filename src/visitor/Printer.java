package visitor;

public class Printer implements Visitor {
    public void visitConstant(Constant c) {
        System.out.print(c.getValue());
    }

    public void visitSum(Sum s) {
        // inorder : process left child of s, then s, then right child of s
        System.out.print("(");
        s.left.acceptVisitor(this);
        System.out.print(")");
        System.out.print(" + ");
        System.out.print("(");
        s.right.acceptVisitor(this);
        System.out.print(")");
    }

    public void visitSubtract(Subtract s) {
        System.out.print("(");
        s.left.acceptVisitor(this);
        System.out.print(")");
        System.out.print(" - ");
        System.out.print("(");
        s.right.acceptVisitor(this);
        System.out.print(")");
    }

    public void visitProduct(Product p) {
        System.out.print("(");
        p.left.acceptVisitor(this);
        System.out.print(")");
        System.out.print(" * ");
        System.out.print("(");
        p.right.acceptVisitor(this);
        System.out.print(")");
    }

    public void visitDivision(Division d) {
        System.out.print("(");
        d.left.acceptVisitor(this);
        System.out.print(")");
        System.out.print(" / ");
        System.out.print("(");
        d.right.acceptVisitor(this);
        System.out.print(")");
    }
}
