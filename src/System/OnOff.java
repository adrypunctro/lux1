/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Clients.Audio;

/**
 *
 * @author ASimionescu
 */
public class OnOff
{
    private static class InstanceHolder {
        private static final OnOff INSTANCE = new OnOff();
    }
    
    public static OnOff getInstance()
    {
        return InstanceHolder.INSTANCE;
    }
    
    public static void startProgram()
    {
        VA_DEBUG.INFO("[ONOFF] Program starting ::::::::::::::::::::::::::::::::", true, 1);
        
        // Init
        Audio audio = new Audio();
        
        ChannelManager manager = ChannelManager.getInstance();
        
        manager.init();
        manager.startProcess();

        audio.registerClient();
        
        
        VA_DEBUG.INFO("[ONOFF] Program is runing :::::::::::::::::::::::::::::::", true, 1);
        

        
    }
    
    
}
