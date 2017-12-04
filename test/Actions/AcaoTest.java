/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import batalhanaval.Entidade;
import batalhanaval.Seletor;
import junit.framework.TestCase;

/**
 *
 * @author Alef
 */
public class AcaoTest extends TestCase {
    private Entidade etd = new Seletor();
    
    public AcaoTest(String testName) {
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
     * Test of verificarPosicao method, of class Acao.
     */
    public void testVerificarPosicao() {
        assertTrue(Acao.verificarPosicao(etd, 0, 1, 10));
        assertFalse(Acao.verificarPosicao(etd, -1, 0, 10));
        assertFalse(Acao.verificarPosicao(etd, 10, 10, 10));
    }
}
