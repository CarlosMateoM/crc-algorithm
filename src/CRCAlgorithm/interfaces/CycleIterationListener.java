package CRCAlgorithm.interfaces;

import CRCAlgorithm.model.CRC;

/**
 *
 * @author mateo092
 */
public interface CycleIterationListener {
    void notifyAlgorithmStart();
    void notifyAlgorithmFinish(CRC crc);
    void notifyCycleIteration(CRC crc);
}
