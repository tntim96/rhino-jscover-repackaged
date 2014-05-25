/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

/**
 * 
 */
package jscover.mozilla.javascript.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import jscover.mozilla.javascript.CompilerEnvirons;
import jscover.mozilla.javascript.Context;
import jscover.mozilla.javascript.ErrorReporter;
import jscover.mozilla.javascript.Parser;
import jscover.mozilla.javascript.ast.AstRoot;

/**
 * @author André Bargull
 * 
 */
public class Bug688021Test {
    private Context cx;

    @Before
    public void setUp() {
        cx = Context.enter();
        cx.setLanguageVersion(Context.VERSION_1_8);
    }

    @After
    public void tearDown() {
        Context.exit();
    }

    private AstRoot parse(CharSequence cs) {
        CompilerEnvirons compilerEnv = new CompilerEnvirons();
        compilerEnv.initFromContext(cx);
        ErrorReporter compilationErrorReporter = compilerEnv.getErrorReporter();
        Parser p = new Parser(compilerEnv, compilationErrorReporter);
        return p.parse(cs.toString(), "<eval>", 1);
    }

    private String toSource(CharSequence cs) {
        return parse(cs).toSource();
    }

    @Test
    public void testToSource() {
        assertEquals("debugger;\n", toSource("debugger"));
        assertEquals("debugger;\n", toSource("debugger;"));
        assertEquals("debugger;\n", toSource("debugger;\n"));
    }

}
