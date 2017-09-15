/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer.common;

/**
 *
 * @author frive
 */
public class Flag {
    
    private boolean flag;
    
    public Flag(Boolean val){
        flag = val;
    }
    
    public Flag(){
        flag = false;
    }
    
    public void setRun(){
        synchronized(this){
            flag=true;
        }
    }
    
    public void setStop(){
        synchronized(this){
            flag=false;
        }
    }
    
    public Boolean getState(){
        synchronized(this){
            return flag;
        }
    }
    
}
