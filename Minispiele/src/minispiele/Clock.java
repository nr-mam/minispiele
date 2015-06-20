/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minispiele;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marc
 */
public class Clock implements Runnable {

    private Thread t;
    private int h, min, s, ms;
    private boolean stop, end;

    public Clock() {
        stop = false;
        end = false;
        h = 0;
        min = 0;
        s = 0;
        ms = 0;
        t = new Thread(this);
    }

    @Override
    public void run() {
        boolean doSchleife = true;

        while (doSchleife) {
            try {
                t.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!stop) {
                ms += 10;
                if (ms == 1000) {
                    s += 1;
                    ms = 0;
                }
                if (s == 60) {
                    min += 1;
                    s = 0;
                }
                if (min == 60) {
                    h += 1;
                    min = 0;
                }
            }
            if (end) {
                doSchleife = false;
            }

        }
    }

    public void resetAll() {
        h = 0;
        min = 0;
        s = 0;
        ms = 0;
    }

    public Thread getT() {
        return t;
    }

    public int getH() {
        return h;
    }

    public int getMin() {
        return min;
    }

    public int getS() {
        return s;
    }

    public int getMs() {
        return ms;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
    

}
