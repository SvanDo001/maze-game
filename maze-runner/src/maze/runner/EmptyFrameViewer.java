package maze.runner;

import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public abstract class EmptyFrameViewer {
    private JFrame frame = new JFrame();
    private static final int FRAME_WIDTH = 464;
    private static int FRAME_HEIGHT = 495;
    
    public EmptyFrameViewer() {
        
    }
    
    public void EmptyFramer() {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("An Empty Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
}
