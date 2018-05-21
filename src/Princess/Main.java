package Princess;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
       
import ANTLR.*;

public class Main {
    public static void main(String[] args) {
        try {
            PrincessLexer lexer = new PrincessLexer(new ANTLRFileStream("src/Tests/syntaxTest.lk"));
            PrincessParser parser = new PrincessParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.parse();
            
            Scope scope = new Scope();
            Map<String, Function> functions = new HashMap<String, Function>();
            SymbolVisitor symbolVisitor = new SymbolVisitor(functions);
            symbolVisitor.visit(tree);
            EvalVisitor visitor = new EvalVisitor(scope, functions);
            visitor.visit(tree);
        } catch (Exception e) {
            if ( e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }
}
