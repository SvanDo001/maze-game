package maze.runner;

import javax.swing.*;

/**
 *
 * @author Stefan van Doodewaard
 */
public abstract class EmptyFrameViewer
{
    private JFrame frame = new JFrame();
    private final int FRAME_WIDTH;
    private final int FRAME_HEIGHT;
    
    public EmptyFrameViewer()
    {
        this.FRAME_WIDTH = 500;
        this.FRAME_HEIGHT = 400;
    }
    
    public JFrame EmptyFrame()
    {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("An Empty Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        
        return frame;
    }
}
