
package lab5;

import java.awt.*;
import javax.swing.*;

import data.*;
/**
 *
 * @author NikitaShokorov
 */
public class Lab5 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExperimentTimes times = new ExperimentTimes();
                GeneralFrame frame1 = new GeneralFrame();
                frame1.setTitle("Total Add: Legend: Array - BLUE, Linked - RED.");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
                frame1.addGraph(new Graph(2, times.getArrayListAddTimes(), times.getLinkedListAddTimes()));
                frame1.pack();

                GeneralFrame frame2 = new GeneralFrame();
                frame2.setTitle("Total Remove: Legend: Array - BLUE, Linked - RED.");
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setVisible(true);
                frame2.addGraph(new Graph(2, times.getArrayListRemoveTimes(), times.getLinkedListRemoveTimes()));
                frame2.pack();
            }
        });

    }
}

class GeneralFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private int DEF_Height = 650;
    private int DEF_Width = 850;
    private JComponent graph;
    public GeneralFrame() {
        setSize(this.DEF_Width, this.DEF_Height);
    }

    public void addGraph(JComponent g) {
        graph = g;
        add(graph);
    }
    public JComponent getGraph() {
        return graph;
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEF_Width, DEF_Height);
    }
}

class Graph extends JComponent {
    private static final long serialVersionUID = 2L;
    private static final int H = 600;
    private static final int W = 800;

    private static int xOffset = 25;
    private static int yOffset = 25;

    private GraphPoint[][] dataArray;
    private int dataN;

    private Color mainColor = Color.BLUE;

    public Graph(int N, GraphPoint[] ... dataArr) {
        dataN = N;
        dataArray = new GraphPoint[N][];
        for (int i = 0; i <N; i++) {
            dataArray[i] = dataArr[i];
        }
    }

    private int XtoFrameX(long x, long maxX) {
        return (int) ((x * W / maxX) + xOffset);
    }

    private int YtoFrameY(long y, long maxY) {
            return (int)(H - ((y * H / maxY)) + yOffset);
    }

    private void drawAxis(Graphics2D g2) {
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(XtoFrameX(0, W), YtoFrameY(0, H), XtoFrameX(0, W), YtoFrameY(H, H));
        g2.drawLine(XtoFrameX(0, W), YtoFrameY(0, H), XtoFrameX(W, W), YtoFrameY(0, H));
        int[] xpx = {XtoFrameX(-5, W), XtoFrameX(0, W), XtoFrameX(5, W)};
        int[] xpy = {YtoFrameY(H-15, H), YtoFrameY(H, H), YtoFrameY(H-15, H)};
        g2.fillPolygon(xpx, xpy , 3);
        g2.drawPolygon(xpx, xpy , 3);
        g2.drawString("Time, nanoseconds", XtoFrameX(15, W), YtoFrameY(H-10, H));
        int[] ypx = {XtoFrameX(W-15, W), XtoFrameX(W, W), XtoFrameX(W-15, W)};
        int[] ypy = {YtoFrameY(5, H), YtoFrameY(0, H), YtoFrameY(-5, H)};
        g2.fillPolygon(ypx, ypy , 3);
        g2.drawPolygon(ypx, ypy , 3);	
        g2.drawString("Number of elements", XtoFrameX(W, W), YtoFrameY(10, H));
        g2.drawString("1 = 10, 2 = 100, 3 = 1000, 4 = 10000, 5 = 100000", XtoFrameX(400, W), YtoFrameY(-50, H));
    }

    private Boolean flag = true;
    private void drawGraph(Graphics2D g2, GraphPoint[] data) {
        long dataMaxX = 0;
        long dataMaxY = 0;
        for (GraphPoint p: data) {
            if (p.getX() > dataMaxX)
                dataMaxX = p.getX();
            if (p.getY() > dataMaxY)
                dataMaxY = p.getY();
        }
        dataMaxY *= 2;
        g2.setStroke(new BasicStroke(2));
        Boolean isFirst = true;
        GraphPoint prevP = null;
        for (GraphPoint p: data) {
            if (!isFirst) {
                g2.drawLine(XtoFrameX(prevP.getX(), dataMaxX), YtoFrameY(prevP.getY(), dataMaxY),
                            XtoFrameX(p.getX(), dataMaxX), YtoFrameY(p.getY(), dataMaxY));
            }
            else 
                    isFirst = false;
            g2.fillOval(XtoFrameX(p.getX(), dataMaxX) - 5, YtoFrameY(p.getY(), dataMaxY) - 5, 10, 10);
            if (flag) {
                g2.drawString("" + p.getY(), XtoFrameX(p.getX(), dataMaxX) + 10, YtoFrameY(p.getY(), dataMaxY) + 10);
                Color tmp = g2.getColor();
                g2.setColor(Color.BLUE);
                g2.drawString("" + p.getX(), XtoFrameX(p.getX(), dataMaxX), YtoFrameY(-20, H));	
                g2.setColor(tmp);
            }
            else {
                g2.drawString("" + p.getY(), XtoFrameX(p.getX(), dataMaxX), YtoFrameY(p.getY(), dataMaxY) - 10);
            }
            prevP = p;
        }
        flag = !flag;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //—глаживание
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        g2.setColor(Color.BLACK);
        drawAxis(g2);
        Color[] colors = {mainColor, Color.RED, Color.YELLOW};
        for (int i = 0; i < dataN; i++) {
            g2.setColor(colors[i%3]);
            drawGraph(g2, dataArray[i]);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(W + 2 * xOffset, H + 2 * yOffset);
    }
}