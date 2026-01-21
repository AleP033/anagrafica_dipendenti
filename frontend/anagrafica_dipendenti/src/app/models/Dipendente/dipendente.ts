import { Responsabile } from "../Responsabile/responsabile";
import { Contratto } from "../Contratto/contratto";
import { Commessa } from "../Commessa/commessa";
import { Timesheet } from "../Timesheet/timesheet";

export class Dipendente {

    id?: number;
    nome?: string;
    cognome?: string;
    email?: string;

    responsabile? : Responsabile;
    contratto? : Contratto;
    commesse? : Commessa[];
    timesheets? : Timesheet[]

}


