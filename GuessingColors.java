import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingColors extends JFrame{

    static int sampleR = 0;
    static int sampleG = 0;
    static int sampleB= 0;

    static Color sampleColor = new Color (sampleR, sampleG, sampleB);

    static int targetR = (int) Math.floor(Math.random() * 8) *30;
    static int targetG = (int) Math.floor(Math.random() * 8) *30;
    static int targetB = (int) Math.floor(Math.random() * 8) *30;

    Color targetColor = new Color(targetR, targetG, targetB);

    Container mainContainer = this.getContentPane();

    public GuessingColors(){

        initGUI();
        setTitle("Guessing Colors Game");
        setSize(540,440);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(new DrawPanel());
    }

    private void initGUI(){
        mainContainer.setLayout(new BorderLayout(8,6));
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.DARK_GRAY));

        JLabel title = new JLabel("Guess the Color!", JLabel.CENTER);
        Font font = new Font("Times New Roman", Font.BOLD, 50);
        title.setFont(font);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        mainContainer.add(title, BorderLayout.NORTH);

        Font buttonFont = new Font("Times New Roman", Font.BOLD, 30);

        JButton plusR = new JButton("+");
        plusR.setFont(buttonFont);
        plusR.setBackground(Color.RED);
        plusR.setForeground(Color.WHITE);

        JButton minusR = new JButton("-");
        minusR.setFont(buttonFont);
        minusR.setBackground(Color.RED);
        minusR.setForeground(Color.WHITE);

        JButton plusG = new JButton("+");
        plusG.setFont(buttonFont);
        plusG.setBackground(Color.GREEN);
        plusG.setForeground(Color.WHITE);

        JButton minusG = new JButton("-");
        minusG.setFont(buttonFont);
        minusG.setBackground(Color.GREEN);
        minusG.setForeground(Color.WHITE);

        JButton plusB = new JButton("+");
        plusB.setFont(buttonFont);
        plusB.setBackground(Color.BLUE);
        plusB.setForeground(Color.WHITE);

        JButton minusB = new JButton("-");
        minusB.setFont(buttonFont);
        minusB.setBackground(Color.BLUE);
        minusB.setForeground(Color.WHITE);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setForeground(Color.WHITE);
        bottomPanel.setBorder(new LineBorder(Color.BLACK));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        bottomPanel.add(plusR);
        bottomPanel.add(minusR);
        bottomPanel.add(plusG);
        bottomPanel.add(minusG);
        bottomPanel.add(plusB);
        bottomPanel.add(minusB);
        bottomPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainContainer.add(bottomPanel, BorderLayout.SOUTH,(int)JPanel.CENTER_ALIGNMENT);

        plusR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("button 1 pressed");
                plusRed();
                repaint();
                check();
            }
        });
        minusR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("button 2 pressed");
                minusRed();
                repaint();
                check();
            }
        });
        plusG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("button 3 pressed");
                plusGreen();
                repaint();
                check();
            }
        });
        minusG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minusGreen();
                repaint();
                check();
            }
        });
        plusB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plusBlue();
                repaint();
                check();
            }
        });
        minusB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minusBlue();
                repaint();
                check();
            }
        });


    }
    private static void plusRed(){
        if (sampleR < 240){
            sampleR += 30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }
    private static void minusRed(){
        if (sampleR > 0){
            sampleR -= 30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }
    private static void plusGreen(){
        if (sampleG < 240){
            sampleG += 30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }
    private static void minusGreen(){
        if (sampleG > 0){
            sampleG-=30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }
    private static void plusBlue(){
        if (sampleB < 240){
            sampleB += 30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }
    private static void minusBlue(){
        if (sampleB > 0){
            sampleB -= 30;
            sampleColor = new Color(sampleR, sampleG, sampleB);
        }
    }

    private static void check(){
        if(sampleR == targetR && sampleG == targetG && sampleB == targetB){
            int choose = JOptionPane.showConfirmDialog(null, "Awesome"
            +"\nThe color was R; " + sampleR + " G: " + sampleG + " B: " + sampleB
            +"\nDo you want to play again?", "you win!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(choose == JOptionPane.YES_OPTION){
                reset();
            } else if (choose == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
    }

    private static void reset(){

        targetR = (int) Math.floor(Math.random() * 8) * 30;
        targetG = (int) Math.floor(Math.random() * 8) * 30;
        targetB = (int) Math.floor(Math.random() * 8) * 30;
        sampleR = 0;
        sampleG = 0;
        sampleB = 0;
        sampleColor = new Color(sampleR, sampleG, sampleB);
        new GuessingColors();
    }

    public static void main(String[] args) {
        new GuessingColors();
    }

    private class DrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(sampleColor);
            g.fillRect(40,5,220,250);

//            for(int i = 0; i < 256; i+=30){
//                r = (int)(Math.random()*i);
//                gr = (int)(Math.random()*i);
//                b = (int)(Math.random()*i);
//            }
//            g.setColor(new Color(r,gr,b));
            g.setColor(targetColor);
            g.fillRect(265,5,220,250);
        }

    }

}
