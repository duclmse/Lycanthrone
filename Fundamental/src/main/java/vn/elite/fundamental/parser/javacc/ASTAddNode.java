package vn.elite.fundamental.parser.javacc;

import java.util.Map;

/* Generated By:JJTree: Do not edit this line. ASTAddNode.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTAddNode extends SimpleNode {
    public ASTAddNode(int id) {
        super(id);
    }

    public ASTAddNode(ExampleCompiler p, int id) {
        super(p, id);
    }

    @Override
    public AlgValue eval(Map<String, AlgValue> symbolTable) throws InterpreterException {
        if (jjtGetNumChildren() < 1) {
            throw new InterpreterException();
        }
        AlgValue variable = getChild(0).eval(symbolTable);
        for (int i = 1; i < jjtGetNumChildren(); i++) {
            variable = add(variable, getChild(i).eval(symbolTable));
        }

        return variable;
    }

    private AlgValue add(AlgValue a, AlgValue b) throws InterpreterException {
        if (a == null || b == null) {
            throw new InterpreterException();
        }
        if (a.getType() == Type.INT && b.getType() == Type.INT) {
            return new AlgValue(Type.INT, (int) a.getValue() + (int) b.getValue());
        }
        if (a.getType() == Type.STRING && a.getValue() != null) {
            return new AlgValue(Type.STRING, a.getValue().toString() + b.getValue());
        }
        if (b.getType() == Type.STRING && b.getValue() != null) {
            return new AlgValue(Type.STRING, a.getValue() + b.getValue().toString());
        }
        throw new InterpreterException();
    }
}
/*
 * JavaCC - OriginalChecksum=ea8acdfcf138d65be603bf5e747fc342 (do not edit this
 * line)
 */
