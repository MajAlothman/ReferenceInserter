
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;




class GlobalGUIListener extends GlobalListener {
    Boolean mask_slash  = false;
    Boolean mask_c      = false;
    Boolean mask_i      = false;
    Boolean mask_t      = false;
    Boolean mask_e      = false;
    
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_F1) {//this will stop the application , you can change the value of VK_F1 with the one approprite for you
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getKeyCode() == NativeKeyEvent.VC_SLASH){
            mask_slash = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VC_C &&mask_slash){   
            mask_c = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VC_I && mask_slash && mask_c){
            mask_i = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VC_T && mask_slash && mask_c && mask_i){
            mask_t = true;
        }
        else if(e.getKeyCode() == NativeKeyEvent.VC_E && mask_slash && mask_c && mask_i && mask_t){
            try {
                Thread.sleep(20);
                GUI.changeStateNormal();
                mask_slash  = false;
                mask_c      = false;
                mask_i      = false;
                mask_t      = false;
                mask_e      = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(GlobalGUIListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            mask_slash  = false;
            mask_c      = false;
            mask_i      = false;
            mask_t      = false;
            mask_e      = false;
        }
    }
    public void nativeKeyReleased(NativeKeyEvent e) {}
     public void nativeKeyTyped(NativeKeyEvent e) {}
}
