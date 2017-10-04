package Clients;

import Messages.ATPMsg;
import Messages.MyMessageType;
import System.MyApplicationId;
import System.ChannelManager;
import System.Client;
import System.OnOffState;
import System.VA_DEBUG;
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASimionescu
 */
public class Audio
    extends Client
{
    public Audio()
    {
        super(MyApplicationId.AUDIO);
    }

    @Override
    public boolean registerClient()
    {
        ChannelManager manager = ChannelManager.getInstance();
        
        if (manager != null)
        {
            return manager.registerClient(this);
        }
        
        return false;
    }
    
    @Override
    public boolean unregisterClient()
    {
        ChannelManager manager = ChannelManager.getInstance();
        
        if (manager != null)
        {
            return manager.unregisterClient(this);
        }
        
        return false;
    }
    
    @Override
    public boolean handleRequest(ATPMsg msg)
    {
        VA_DEBUG.INFO("[AUDIO] handleRequest("+msg.getMsgType().name()+")", true);
        switch((MyMessageType)msg.getMsgType())
        {
            case audioDetectedRequest:
                _handleAudioDetectedRequest(msg);
                break;
            
            default:
                VA_DEBUG.WARNING("[AUDIO] unknown message type received("+msg.getMsgType().name()+")", true);
                return false;
        }
        
        return true;
    }
    
    private boolean _handleAudioDetectedRequest(ATPMsg msg)
    {
        ChannelManager manager = ChannelManager.getInstance();
        
        if (manager == null)
        {
            VA_DEBUG.WARNING("[AUDIO] ChannelManager is null.", true);
            return false;
        }
        
        if (!manager.isClientRegistered(MyApplicationId.AUDIO))
        {
            VA_DEBUG.WARNING("[AUDIO] MEMORY is not registered.", true);
            return false;
        }
        
//        PersonDetectedResponse reply = new PersonDetectedResponse();
//        reply.setSource(MyApplicationId.AUDIO);
//        reply.setTarget(msg.getSourceId());
//        reply.setTransactionId(msg.getTransactionId());
//        
//        manager.send(reply);

        return true;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onoffState(OnOffState state)
    {
        VA_DEBUG.INFO("[AUDIO] Event received : OnOffState "+state.name(), true, 0);
        
        switch(state)
        {
            case ONOFF_STATE_STARTUP_POLLING:
            {    
                break;
            }
            case ONOFF_STATE_NORMAL:
            {
                
                break;
            }
            case ONOFF_STATE_PREPARE_SHUTDOWN:
            {
                
                break;
            }
        }
    }
}
