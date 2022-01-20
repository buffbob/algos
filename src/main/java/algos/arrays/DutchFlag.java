package algos.arrays;

import org.w3c.dom.css.Rect;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DutchFlag {



    public static List<Color> makeDutchFlag(List<Color> colors) {

        return colors;
    }

    public void init() {
        List<Color> cs = new ArrayList<>();
        // {Red, White, Blue}
        Map<Color, Integer> encoder = new HashMap<>();
        encoder.put(Color.RED, 1);
        encoder.put(Color.WHITE, 2);
        encoder.put(Color.BLUE, 3);
        cs.add(Color.BLUE);
        cs.add(Color.WHITE);
        cs.add(Color.BLUE);
        cs.add(Color.WHITE);
        cs.add(Color.RED);
        cs.add(Color.RED);
        cs.add(Color.BLUE);
        cs.add(Color.RED);
        cs.add(Color.BLUE);
        cs.add(Color.WHITE);
        cs.add(Color.WHITE);
        cs.add(Color.BLUE);
        cs.add(Color.RED);
        cs.add(Color.RED);
        cs.add(Color.WHITE);
        DisplayFlag df = new DisplayFlag(cs);
        JFrame f = new JFrame();
        f.setTitle("Dutch Flag Problem");
        f.add(df);
        f.setSize(400,500);
        f.setVisible(true);
        encoder.forEach((k,v) -> System.out.println(k + ":" + v));
        System.out.println("____");
        System.out.println(encoder.get(Color.RED));
    }

    class DisplayFlag extends Canvas {

        List<Color> colors;
        Map<Color, Integer> encoder;
        DisplayFlag(List<Color> l) {
            this.encoder = new HashMap<>();
            encoder.put(Color.RED, 1);
            encoder.put(Color.WHITE, 2);
            encoder.put(Color.BLUE, 3);
            this.colors = l;
        }

//        move red to front
        public void move2Front() {
            int border = 0;
            for (int i = 0; i < this.colors.size(); ++i) {
                if(encoder.get(this.colors.get(i)) < encoder.get(Color.WHITE)) {
                    Collections.swap(this.colors, border++, i);
                }
            }
        }

        public void move2Back() {
            int border = this.colors.size() - 1;
            for (int i = border; i >=0 ; --i) {
                if(encoder.get(this.colors.get(i)) > encoder.get(Color.WHITE)){
                    Collections.swap(this.colors, border--, i);
                }
            }
        }

// todo: try to implement sortFlag using only one loop and 3 partitions and two border indices.
//  See page 42.

        public void sortFlag(){
            move2Front();
            move2Back();
            int redWhiteIdx = 0;
            int whiteBlueIdx = colors.size() - 1;
//            while(redWhiteIdx < whiteBlueIdx) {
////                if(encoder.get(c.get(redWhiteIdx)) <  )
//            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.RED);
            for (int i = 0; i < colors.size(); i++) {
                int x = 40;
                int y = 40 + i*10;
                g.setColor(colors.get(i));
                g.fillRect(x, y, 300, 10);
            }
            sortFlag();
            g.setColor(Color.RED);
            for (int i = 0; i < colors.size(); i++) {
                int x = 40;
                int y = 240 + i*10;
                g.setColor(colors.get(i));
                g.fillRect(x, y, 300, 10);
            }

        }
    }

    public static void main(String[] args) {
        DutchFlag df = new DutchFlag();
        df.init();
        System.out.println();
    }
}
