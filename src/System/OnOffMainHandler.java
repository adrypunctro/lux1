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
public class OnOffMainHandler
{
    private static final OnOff ONOFF = OnOff.getInstance();
    
    public static void run()
    {
        VA_DEBUG.INFO("[ONOFF] Program starting ::::::::::::::::::::::::::::::::", true, 1);
        
        // CONFIG --------------------------------------------------------------
        Config.APP_NAME         = "ViSmartHome";
        Config.APP_VERSION      = "1.0";
        Config.PERSISTENCE_DIR  = "/data/persistency/";
        
        // INIT ----------------------------------------------------------------
        ONOFF.init();
        
        // SETUP ---------------------------------------------------------------
        ONOFF.setPersistentFiles(MyPersistentFile.class);
        
        ONOFF.registerClient(new Audio());
        
        
        // STARTUP -------------------------------------------------------------
        ONOFF.startup();
        
        VA_DEBUG.INFO("[ONOFF] Program is runing :::::::::::::::::::::::::::::::", true, 1);
        

        
    }
    
}
