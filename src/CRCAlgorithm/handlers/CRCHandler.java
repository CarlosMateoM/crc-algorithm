package CRCAlgorithm.handlers;

import CRCAlgorithm.interfaces.CycleIterationListener;
import CRCAlgorithm.model.CRC;

/**
 *
 * @author mateo092
 */
public class CRCHandler implements Runnable {

    private CRC crc;
    private CycleIterationListener cycleInterationListener;

    public CRC getCrc() {
        return crc;
    }

    public void setCrc(CRC crc) {
        this.crc = crc;
    }

    public CycleIterationListener getCycleInterationListener() {
        return cycleInterationListener;
    }

    public void setCycleInterationListener(CycleIterationListener cycleInterationListener) {
        this.cycleInterationListener = cycleInterationListener;
    }

    private void sleepForSeconds(int seconds) {
        try {

            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido mientras dormía.");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        int xor = 0;

        crc.setInputPadded(crc.getInputBitstring() + crc.getInitialFiller());

        while (crc.getInputPadded().length() >= crc.getPolynomialBitstring().length()) {

            crc.setCurrentChuck(crc.getInputPadded().substring(0, crc.getPolynomialBitstring().length()));

            crc.setInputPadded(crc.getInputPadded().substring(crc.getPolynomialBitstring().length()));

            cycleInterationListener.notifyCycleIteration(crc);

            sleepForSeconds(5);

            // (^) xor bits operator
            xor = Integer.parseInt(crc.getCurrentChuck(), 2) ^ Integer.parseInt(crc.getPolynomialBitstring(), 2);

            crc.setCurrentChuck(xor == 0 ? "" : Integer.toBinaryString(xor));

            crc.setInputPadded(crc.getCurrentChuck() + crc.getInputPadded());

            crc.setQuotient(crc.getQuotient() + '1');

            if (!crc.getCurrentChuck().contains("1")) {
                crc.setQuotient(crc.getQuotient() + "0".repeat(crc.getPolynomialBitstring().length() - 1));
            }

            cycleInterationListener.notifyCycleIteration(crc);

            sleepForSeconds(5);
        }

    }
}
