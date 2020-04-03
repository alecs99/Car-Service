package contracts;

import model.Angajat;
import model.Rezervari;
import model.ServiceAuto;
import model.Servicii;

import java.util.ArrayList;
import java.util.List;

public abstract class ServiceHelperContract {
    public abstract ServiceAuto creeazaServiceCuDateInitiale();
}
