import { Dipendente } from "../Dipendente/dipendente";
import { Responsabile } from "../Responsabile/responsabile";
import { Timesheet } from "../Timesheet/timesheet";

export class Commessa {

    id? : number;
    titolo? : string;
    descrizione? : string;
    datInizio? : string;
    datFine? : string;
    importo? : number;

    dipRIF? : number[];
    respRIF? : number;
    timRIF? : number[];
}
