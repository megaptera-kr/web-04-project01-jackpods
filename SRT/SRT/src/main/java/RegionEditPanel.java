import models.CompletePayment;
import models.ControlCenter;
import models.Region;
import models.TemporaryStorage;

import javax.swing.*;
import java.util.ArrayList;

public class RegionEditPanel extends ArriveTrainStationSelectionPanel {
    private JButton otehrDongtanButton;

    RegionEditPanel(ArrayList<Region> regionList, ControlCenter controlCenter, TemporaryStorage temporary) {
        super(regionList, controlCenter);
        ArriveTrainStationSelectionPanel arriveTrainStationSelectionPanel = new ArriveTrainStationSelectionPanel(regionList, controlCenter);
        otehrDongtanButton = arriveTrainStationSelectionPanel.dongtanButton;
        otehrDongtanButton.addActionListener(event->{
//            temporary.transfer("동탄");
        });

    }
}

