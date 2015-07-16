
package minispiele;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Diese Klasse erstellt eine Stoppuhr, die dann startet, wenn der Thread 
 * gestartet wird.
 *
 * @author Marc
 */
public class Clock implements Runnable {

    private final Thread t;
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

        //Die Stoppuhr wird gestartet
        while (doSchleife) {
            try {
                t.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!stop) {
                ms += 10;
                if (ms >= 1000) {
                    s += 1;
                    ms = 0;
                }
                if (s >= 60) {
                    min += 1;
                    s = 0;
                }
                if (min >= 60) {
                    h += 1;
                    min = 0;
                }
            }
            if (end) {
                doSchleife = false;
            }
        }
    }

    //Setzt den Timer wieder auf 0
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

    //Stoppt/ Setzt den Timer fort
    // true - fortsetzten
    // false - stoppen
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    //Beendet die Stoppuhr
    public void setEnd() {
        end = true;
    }
}
