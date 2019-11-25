package vn.elite.fundamental.parser.javacc;

import java.util.Map;

/* Generated By:JJTree: Do not edit this line. ASTModNode.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTModNode extends SimpleNode {
    public ASTModNode(int id) {
        super(id);
    }

    public ASTModNode(ExampleCompiler p, int id) {
        super(p, id);
    }

    @Override
    public AlgValue eval(Map<String, AlgValue> symbolTable) throws InterpreterException {
        if (jjtGetNumChildren() < 1) {
            throw new InterpreterException();
        }
        AlgValue variable = getChild(0).eval(symbolTable);
        for (int i = 1; i < jjtGetNumChildren(); i++) {
            variable = mod(variable, getChild(i).eval(symbolTable));
        }

        return variable;
    }

    private AlgValue mod(AlgValue a, AlgValue b) throws InterpreterException {
        if (a == null || b == null) {
            throw new InterpreterException();
        }
        if (a.getType() == Type.INT && b.getType() == Type.INT) {
            return new AlgValue(Type.INT, (int) a.getValue() % (int) b.getValue());
        }
        throw new InterpreterException();
    }
}
/*
 * JavaCC - OriginalChecksum=8c31b8eca31c5fcfa812a5a9413f64b5 (do not edit this
 * line)
 */
