import { Dipendente } from "../Dipendente/dipendente";
import { Responsabile } from "../Responsabile/responsabile";
import { Timesheet } from "../Timesheet/timesheet";

export class Commessa {

    id? : number;
    tit? : string;
    des? : string;
    datIni? : string;
    datFin? : string;
    imp? : number;

    dipRIF? : number[];
    respRIF? : number;
    timRIF? : number[];
}
