/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.util.HashMap;

/**
 *
 * @author Alef
 */
public class InputHandler {
    private HashMap<Integer, Acao> map = new HashMap<Integer, Acao>();
    
    public void limparMapa(){
        map.clear();
    }

    public Acao getAction(Integer key){
        return map.get(key);
    }
    
    public void setAction(Integer key, Acao action){
        map.put(key, action);
    }
}
