package test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by williamz on 2014/7/17.
 */
public class TestJavaScriptEngine {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());
        System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 1;"));
    }

}
