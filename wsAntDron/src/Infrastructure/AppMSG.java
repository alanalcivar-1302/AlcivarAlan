//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package Infrastructure;

import javax.swing.JOptionPane;

public abstract class AppMSG {
    private AppMSG() {}
    public static final void show(String msg){
        JOptionPane.showMessageDialog(null, msg, "🐜 AntCiberDron", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 AntCiberDron", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "🐜 AntCiberDron", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
