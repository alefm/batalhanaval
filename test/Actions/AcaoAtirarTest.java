/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.EstadoJogo;
import batalhanaval.Tabuleiro;
import junit.framework.TestCase;

/**
 *
 * @author Alef
 */
public class AcaoAtirarTest extends TestCase {
    private AcaoAtirar acao = new AcaoAtirar(new EstadoJogo(), new Tabuleiro(10));
    
    public AcaoAtirarTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    /**
     * Test of tiroValido method, of class AcaoAtirar.
     */
    public void testTiroValido() {
        assertTrue(acao.tiroValido(2, 3));
        assertTrue(acao.tiroValido(0, 0));
        assertTrue(acao.tiroValido(9, 9));
        assertFalse(acao.tiroValido(9, 10));
        assertFalse(acao.tiroValido(0, -1));
        
    }
    
}
